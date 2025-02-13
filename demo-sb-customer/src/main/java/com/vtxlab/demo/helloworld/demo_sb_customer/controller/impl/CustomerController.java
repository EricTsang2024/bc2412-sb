package com.vtxlab.demo.helloworld.demo_sb_customer.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.demo.helloworld.demo_sb_customer.codewave.ApiResp;
import com.vtxlab.demo.helloworld.demo_sb_customer.codewave.SysCode;
import com.vtxlab.demo.helloworld.demo_sb_customer.controller.CustomerOperation;
import com.vtxlab.demo.helloworld.demo_sb_customer.entity.CustomerEntity;
import com.vtxlab.demo.helloworld.demo_sb_customer.service.CustomerService;

@RestController// 標記這是一個 RESTful API 控制器類別。通過這個註解，
// Spring 將會自動將控制器方法的返回值序列化為 JSON 或 XML 格式，並返回給客戶端

public class CustomerController implements CustomerOperation {
  // 實現了 CustomerOperation 介面的控制器類別。該類別包含了兩個方法
  // ：getCustomers() 和 createCustomer()，用於處理客戶端的請求

  @Autowired // Spring Framework 提供的註解，用於自動注入依賴的實例
  private CustomerService customerService;
  // 將一個 CustomerService 實例注入到 CustomerController 中，以便在控制器方法中使用

  @Override
  public ApiResp<List<CustomerEntity>> getCustomers() {
    // 首先調用 customerService.getCustomers() 方法獲取客戶列表資料
    List<CustomerEntity> customerEntities = this.customerService.getCustomers();
    return ApiResp.<List<CustomerEntity>>builder() //
    // 將資料封裝成一個包含 SysCode.OK 和客戶列表的 ApiResp 物件並返回
        .syscode(SysCode.OK) //
        .data(customerEntities) //
        .build();
  }

  @Override
  public ApiResp<CustomerEntity> createCustomer(CustomerEntity customerEntity) {
    CustomerEntity serviceResult =
        this.customerService.createCustomer(customerEntity);
    return ApiResp.<CustomerEntity>builder() //
        .syscode(SysCode.OK) //
        .data(serviceResult) //
        .build();
  }
}