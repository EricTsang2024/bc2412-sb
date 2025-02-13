package com.vtxlab.demo.helloworld.demo_sb_customer.controller;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.vtxlab.demo.helloworld.demo_sb_customer.codewave.ApiResp;
import com.vtxlab.demo.helloworld.demo_sb_customer.entity.CustomerEntity;


public interface CustomerOperation { // 介面是一種定義了方法簽名但沒有方法實作的類型

  @GetMapping(value = "/customers")
  ApiResp<List<CustomerEntity>> getCustomers();
  // 定義了一個名為 getCustomers 的方法，並使用了 @GetMapping 註解來標記這是一個用於處理 HTTP GET 請求的方法。
  // 這個方法應該回傳一個 List<CustomerEntity>，用於獲取客戶資料

   @PostMapping(value = "/customer") 
   // 使用了 @PostMapping 註解來標記這是一個用於處理 HTTP POST 請求的方法
  ApiResp<CustomerEntity> createCustomer(@RequestBody CustomerEntity customerEntity);
  // 在介面中定義了一個名為 createCustomer 的方法
  // 接收一個 CustomerEntity 物件作為輸入參數，並返回一個 CustomerEntity，用於創建新的客戶

  // @RequestBody 註解用於處理 HTTP 請求的內容，將請求的內容（通常是 JSON 或 XML 格式的資料）映射到方法的參數上。
  // 當您在 Controller 方法的參數上使用 @RequestBody 註解時，Spring 將自動處理請求的內容，並將其轉換為方法所需的對象或資料類型
  // 當客戶端通過 HTTP POST 請求向伺服器端傳遞一個 JSON 格式的客戶資料時，您可以在 Controller 方法的參數上使用 @RequestBody 註解
  // ，Spring MVC 將自動將 JSON 資料映射為對應的 Java 物件（例如 CustomerEntity），使您可以方便地處理並使用這些資料

  // @RequestBody 註解來將請求的內容轉換為對應的 Java 物件，使得處理和操作資料變得更加方便。這在需要處理較複雜的資料結構或內容時非常有用
  // 當您需要傳遞包含運算內容或較複雜結構的資料時，通常會使用 @RequestBody。
  // 而當僅需獲取單一值或基本資料時，則可以使用 @RequestParam
  // @RequestParam: 主要用於處理簡單的查詢參數（Query Parameters），例如數字、字串或其他基本資料類型。
  // 開發者可以使用 @RequestParam 註解來直接獲取查詢參數的值，而無需將其轉換為特定的資料結構
}