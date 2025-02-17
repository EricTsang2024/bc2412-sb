package com.vtxlab.demo.helloworld.demo_sb_customer;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import org.hamcrest.MatcherAssert;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import java.util.Arrays;
import java.util.List;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.ResultActions;
import com.vtxlab.demo.helloworld.demo_sb_customer.codewave.ApiResp;
import com.vtxlab.demo.helloworld.demo_sb_customer.controller.impl.CustomerController;
import com.vtxlab.demo.helloworld.demo_sb_customer.entity.CustomerEntity;
import com.vtxlab.demo.helloworld.demo_sb_customer.service.CustomerService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

// Every Test file is a testing env, with your target bean cycle.
// ! For Unit Test, we don't need service & repository layer (bean).
// 撰寫用於測試 CustomerController 的單元測試。這些測試是為了驗證控制器在處理請求時的行為和返回結果是否符合預期
// 這些測試用例旨在確保您的控制器在處理請求時能夠正確返回預期的結果。
// 通過撰寫這些單元測試，您可以確保您的應用程式在接受請求時能夠正確處理和返回數據

@WebMvcTest(controllers = CustomerController.class) // ! Context includes all web related beans ONLY.
// 使用了 @WebMvcTest 注解來設置測試環境，該注解僅包含與 Web 相關的 bean，不包含服務層和存儲庫層的 bean

class CustomerControllerTest {
  @MockBean // 使用 @MockBean 注解來模擬 CustomerService 服務層的行為
  private CustomerService customerService;

  // ! @WebMvcTest inject MockMvc Bean into context
  @Autowired
  private MockMvc mockMvc; // pretend Postman

  @Test
  void testGetAllCustomers() throws Exception {
    // Mock behavior for the mock bean
    // 設定了 customerService.getCustomers() 方法的模擬行為，並模擬了兩個客戶實體的返回結果
    CustomerEntity customerEntity1 = CustomerEntity.builder()
        .email("test123@gmail.com").name("testname1").id(99L).build();
    CustomerEntity customerEntity2 = CustomerEntity.builder()
        .email("test234@gmail.com").name("testname2").id(999L).build();
    List<CustomerEntity> serviceResult =
        Arrays.asList(customerEntity1, customerEntity2);

    // Assume the behavior/result for the mock bean
    // 使用 Mockito 的 when 方法來模擬 customerService.getCustomers() 方法的返回結果
    Mockito.when(customerService.getCustomers()).thenReturn(serviceResult);

    // Test
    // verify result
    // 通過使用 MockMvc 來模擬發送 GET 請求 /customers，並驗證返回的狀態碼和 JSON 內容
    ResultActions result = mockMvc.perform(get("/customers"));
    result.andExpect(status().isOk())
        .andExpect(content().contentType(MediaType.APPLICATION_JSON));

    // To check the data:
    // Approach 1
    // 使用兩種不同的方法驗證返回的 JSON 數據
    // 直接使用 jsonPath 斷言
    result.andExpect(jsonPath("$.code").value("000000"))
        .andExpect(jsonPath("$.message").value("Success."))
        .andExpect(jsonPath("$.data[0].name").value("testname1"))
        .andExpect(jsonPath("$.data[0].email").value("test123@gmail.com"));

    // Approach 2
    // 將 JSON 數據轉換為對象，然後進行斷言
    String json = result.andReturn().getResponse().getContentAsString();

    ApiResp<List<CustomerEntity>> customerEntityArray = new ObjectMapper()
        .readValue(json, new TypeReference<ApiResp<List<CustomerEntity>>>() {});

    MatcherAssert.assertThat(customerEntityArray.getCode(), Matchers.is("000000"));
    MatcherAssert.assertThat(customerEntityArray.getMessage(), Matchers.is("Success."));

    List<CustomerEntity> customerEntities = customerEntityArray.getData();

    MatcherAssert.assertThat(customerEntities, Matchers.containsInAnyOrder( //
        Matchers.hasProperty("email", Matchers.equalTo("test123@gmail.com")), //
        Matchers.hasProperty("email", Matchers.equalTo("test234@gmail.com")) //
    ));
  }

  @Test
  void testCreateCustomer() {

  }
}
