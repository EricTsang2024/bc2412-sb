package com.vtxlab.demo.helloworld.class_demo_helloworld;


import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.vtxlab.demo.helloworld.class_demo_helloworld.ShoppMall.Cinema;
import com.vtxlab.demo.helloworld.class_demo_helloworld.ShoppMall.Cinema.Film;

// Java Object -> JSON (Serialization)
// JSON -> Java Object (Deserialization)

// List & Array (JSON)

// Attribute has no ordering in JSON.

@Controller // @GetMapping
@ResponseBody // JSON
// 指示 Spring 將方法的回傳值直接序列化為 JSON 格式並放入 HTTP 回應的主體中。
// 這樣客戶端可以直接收到序列化後的資料
public class HelloworldController {
  // An API for Getting Resource
  // 使用 @GetMapping 標註來標識每個 API 方法，指定了該方法處理的 HTTP GET 請求。
  // 這樣的設定讓 Spring MVC 能夠正確映射請求路徑並調用對應的方法。
  
  @GetMapping(value = "/greeting") // unique //  API 方法返回了String類型的資料
  // 這樣的設計讓您可以靈活地回傳不同種類的資料給客戶端。
  public String hello() {
    return "Hello World !";
  }

  // Create another API to return an Integer
  @GetMapping(value = "/integer") // API 方法返回了Integer類型的資料
  public Integer getInteger() {
    return 100;
  }

  // Create another API to return Integer array
  @GetMapping(value = "/integers")  // API 方法返回了陣列類型的資料
  public Integer[] getIntegers() {
    return new Integer[] {3, 100, 2};
  }

  // Create another API to return List of String
  @GetMapping(value = "/strings")  // API 方法返回了list類型的資料
  public List<String> getStrings() {
    return Arrays.asList("vincent", "lucas");
  }

  // Create another API to return a Cat
  @GetMapping(value = "/cat")  // API 方法返回了自定義的 Cat 類別的資料
  public Cat getCat() {
    return new Cat("John", 3);
  }

  // Create another API to return a List of Cat
  @GetMapping(value = "/cats")
  public List<Cat> getCats() {
    return Arrays.asList(new Cat("John", 3), new Cat("Sally", 4));
  }

  // Create another API to return a List of LocalDate
  @GetMapping(value = "/dates")  // API 方法返回了localDate類別的資料
  public List<LocalDate> getDates() {
    return Arrays.asList(LocalDate.of(2024, 11, 2), LocalDate.of(2025, 11, 2));
  }

  @GetMapping(value = "/shoppingmall")
  public ShoppMall getShopmall() {
    ShoppMall.Cinema.Film film1 = Film.builder() 
      .name("123")
      .releaseDate(LocalDate.of(2024, 10, 2))
      .build();
    ShoppMall.Cinema.Film film2 = Film.builder() 
      .name("234")
      .releaseDate(LocalDate.of(2025, 10, 2))
      .build();
    ShoppMall.Cinema cinema = Cinema.builder()
      .releasedFilms(new Film[] {film1, film2})
      .name("ABC")
      .build();
    return ShoppMall.builder()
      .name("K11")
      .area(100000)
      .cinema(cinema)
      .shopCategory(new String[] {"Clothing", "Sport"})
      .build();
  }
}
