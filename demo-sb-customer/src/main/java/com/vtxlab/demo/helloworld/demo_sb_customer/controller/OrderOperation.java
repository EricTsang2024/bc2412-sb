package com.vtxlab.demo.helloworld.demo_sb_customer.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.vtxlab.demo.helloworld.demo_sb_customer.codewave.ApiResp;
import com.vtxlab.demo.helloworld.demo_sb_customer.entity.OrderEntity;

public interface OrderOperation {
  // 定義了一個名為 OrderOperation 的介面，其中包含了一個用於創建訂單的方法 createOrder
  
  // localhost:8100/order?cid=2
  @PostMapping(value = "/order")
  // 這個方法用於創建訂單，並接收客戶ID（customerId）和訂單實體（orderEntity）。
  // 請注意，通常在介面中，不應該直接使用 @RequestParam 和 @RequestBody，這些通常應當用在 Controller 的方法中
  ApiResp<OrderEntity> createOrder(@RequestParam(value = "cid") Long customerId,
      @RequestBody OrderEntity orderEntity);
}
