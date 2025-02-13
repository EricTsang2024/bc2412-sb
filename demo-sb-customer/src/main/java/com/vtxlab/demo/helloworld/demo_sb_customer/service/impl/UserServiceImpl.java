package com.vtxlab.demo.helloworld.demo_sb_customer.service.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import com.vtxlab.demo.helloworld.demo_sb_customer.entity.AddressEntity;
import com.vtxlab.demo.helloworld.demo_sb_customer.entity.CompanyEntity;
import com.vtxlab.demo.helloworld.demo_sb_customer.entity.GeoEntity;
import com.vtxlab.demo.helloworld.demo_sb_customer.entity.UserEntity;
import com.vtxlab.demo.helloworld.demo_sb_customer.entity.mapper.EntityMapper;
import com.vtxlab.demo.helloworld.demo_sb_customer.model.dto.UserDto;
import com.vtxlab.demo.helloworld.demo_sb_customer.repository.AddressRepository;
import com.vtxlab.demo.helloworld.demo_sb_customer.repository.CompanyRepository;
import com.vtxlab.demo.helloworld.demo_sb_customer.repository.GeoRepository;
import com.vtxlab.demo.helloworld.demo_sb_customer.repository.UserRepository;
import com.vtxlab.demo.helloworld.demo_sb_customer.service.UserService;

// 
@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private RestTemplate restTemplate;
  // 將 RestTemplate 實例注入到 UserServiceImpl類別中，以便後續使用 RestTemplate 來發送 HTTP 請求
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private AddressRepository addressRepository;
  @Autowired
  private CompanyRepository companyRepository;
  @Autowired
  private GeoRepository geoRepository;
// 注入了使用者資料、地址、公司和地理位置的存儲庫，以便在處理用戶數據時進行數據庫操作

  @Autowired
  private EntityMapper entityMapper;
  // 注入了 EntityMapper 實例，用於映射 UserDto 對象到實體對象之間的轉換

  @Value("${api.jsonplaceholder.domain}")
  private String domain;
// 使用 @Value 注解將配置文件中的屬性值注入到 domain 和 usersEndpoint 字串變數中，從而設置 API 的域名和端點
  @Value("${api.jsonplaceholder.endpoints.users}")
  private String usersEndpoint;

  @Override
  public List<UserDto> getUsers() {
    // String url = "https://jsonplaceholder.typicode.com/users";
    // 通過 UriComponentsBuilder 創建 API 請求的 URL，包括協議、主機名和端點
    String url = UriComponentsBuilder.newInstance()
      .scheme("https")
      .host(domain)
      .path(usersEndpoint)
      .build()
      .toUriString();
    System.out.println("url=" + url);

    // 使用 RestTemplate 發送 GET 請求獲取用戶數據，並將返回的 JSON 數據轉換為 UserDto 對象的列表
    List<UserDto> userDtos =
        Arrays.asList(this.restTemplate.getForObject(url, UserDto[].class));
    // Clear DB
    // 清空數據庫中的所有地理位置、地址、公司和用戶數據，為將新數據保存準備數據庫
    this.geoRepository.deleteAll();
    this.addressRepository.deleteAll();
    this.companyRepository.deleteAll();
    this.userRepository.deleteAll();
    
    // Save DB (procedures)
    userDtos.stream().forEach(e -> { // 使用 Java 8 的 Stream API 遍歷用戶數據列表，對每個用戶進行處理

      // 將 UserDto 對象轉換為 UserEntity 對象，並保存到用戶數據庫中
      UserEntity userEntity = this.userRepository.save(this.entityMapper.map(e));

      // 對地址、公司和地理位置等實體進行映射轉換並保存到相應的數據庫表中
      AddressEntity addressEntity = this.entityMapper.map(e.getAddress());
      addressEntity.setUserEntity(userEntity);
      this.addressRepository.save(addressEntity);

      CompanyEntity companyEntity = this.entityMapper.map(e.getCompany());
      companyEntity.setUserEntity(userEntity);
      this.companyRepository.save(companyEntity);

      GeoEntity geoEntity = this.entityMapper.map(e.getAddress().getGeo());
      geoEntity.setAddressEntity(addressEntity);
      this.geoRepository.save(geoEntity);
    });
    return userDtos;
  }
}
