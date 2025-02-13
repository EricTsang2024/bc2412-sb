package com.vtxlab.demo.helloworld.demo_sb_customer.controller.impl;


import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.demo.helloworld.demo_sb_customer.dto.UserDTO;
import com.vtxlab.demo.helloworld.demo_sb_customer.dto.mapper.UserDTOMapper;
import com.vtxlab.demo.helloworld.demo_sb_customer.service.UserService;

@RestController
public class UserController {
  @Autowired
  private UserService userService;
  @Autowired
  private UserDTOMapper userDTOMapper;

  @GetMapping(value = "/jsonplaceholder/users")
  public List<UserDTO> getUsers() {
    // List of UserDto -> List of UserDTO
    return this.userService.getUsers().stream() //
        .map(e -> userDTOMapper.map(e)) //
        .collect(Collectors.toList());
    // List<UserDto> serviceResults = this.userService.getUsers();
    // List<UserDTO> userDTOs = new ArrayList<>();
    // for (UserDto dto : serviceResults) {
    // UserDTO userDTO = userDTOMapper.map(dto);
    // userDTOs.add(userDTO);
    // }
    // return userDTOs;
  }
}