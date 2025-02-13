package com.vtxlab.demo.helloworld.demo_sb_customer.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vtxlab.demo.helloworld.demo_sb_customer.codewave.BusinessException;
import com.vtxlab.demo.helloworld.demo_sb_customer.codewave.SysCode;
import com.vtxlab.demo.helloworld.demo_sb_customer.entity.CustomerEntity;
import com.vtxlab.demo.helloworld.demo_sb_customer.entity.OrderEntity;
import com.vtxlab.demo.helloworld.demo_sb_customer.repository.CustomerRepository;
import com.vtxlab.demo.helloworld.demo_sb_customer.repository.OrderRepository;
import com.vtxlab.demo.helloworld.demo_sb_customer.service.OrderService;

@Service
public class OrderServiceImpl implements OrderService {
  @Autowired
  private CustomerRepository customerRepository;
  @Autowired
  private OrderRepository orderRepository;

  // if customer id not found, throw new BusinessException("Customer ID not found.")
  @Override
  public OrderEntity createOrder(Long customerId, OrderEntity orderEntity) {
    CustomerEntity customerEntity = this.customerRepository.findById(customerId)
        .orElseThrow(() -> BusinessException.of(SysCode.ID_NOT_FOUND));

    orderEntity.setCustomerEntity(customerEntity);
    // Save orderEntity to DB
    return this.orderRepository.save(orderEntity);
  }
}