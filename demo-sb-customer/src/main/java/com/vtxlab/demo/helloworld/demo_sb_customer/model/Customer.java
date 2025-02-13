package com.vtxlab.demo.helloworld.demo_sb_customer.model;

import java.util.LinkedList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class Customer {

  public static final List<Customer> CUSTOMER_DATABASE = new LinkedList<>();
  // 定義了一個名為 CUSTOMER_DATABASE 的靜態 List 變數，用於存儲客戶數據
  private Long id;
  private String name;
  private Integer age;
}
