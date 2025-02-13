package com.vtxlab.demo.helloworld.demo_sb_customer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vtxlab.demo.helloworld.demo_sb_customer.entity.CustomerEntity;
import com.vtxlab.demo.helloworld.demo_sb_customer.service.CustomerService;
import java.util.List;
import com.vtxlab.demo.helloworld.demo_sb_customer.repository.CustomerRepository;


@Service
public class CustomerServiceImpl implements CustomerService {
  @Autowired
  private CustomerRepository customerRepository;

  @Override
  public List<CustomerEntity> getCustomers() {
    return this.customerRepository.findAll();
  }

  @Override
  public CustomerEntity createCustomer(CustomerEntity customerEntity) {
    return this.customerRepository.save(customerEntity);
  }
}