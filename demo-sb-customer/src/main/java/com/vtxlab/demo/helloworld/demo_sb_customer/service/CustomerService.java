package com.vtxlab.demo.helloworld.demo_sb_customer.service;

import com.vtxlab.demo.helloworld.demo_sb_customer.entity.CustomerEntity;
import java.util.List;


public interface CustomerService {
  List<CustomerEntity> getCustomers();
  CustomerEntity createCustomer(CustomerEntity customerEntity);
}