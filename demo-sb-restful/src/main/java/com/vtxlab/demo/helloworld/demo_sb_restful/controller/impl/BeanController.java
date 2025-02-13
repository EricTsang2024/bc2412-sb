package com.vtxlab.demo.helloworld.demo_sb_restful.controller.impl;

import java.util.Arrays;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.demo.helloworld.demo_sb_restful.DemoSbRestfulApplication;

@RestController // @RestController 是 Spring Framework 提供的一個標註，結合了 @Controller 和 @ResponseBody 的功能



public class BeanController {
  @GetMapping(value = "/beans") // 將 HTTP GET 請求映射到控制器方法上，指定了請求的路徑為 /beans
  public List<String> getBeans() { // 這個方法會獲取應用程式上下文中所有 Bean 的名稱，並將它們轉換為字串清單後返回
    return Arrays.asList(DemoSbRestfulApplication.context.getBeanDefinitionNames());
  }
}
