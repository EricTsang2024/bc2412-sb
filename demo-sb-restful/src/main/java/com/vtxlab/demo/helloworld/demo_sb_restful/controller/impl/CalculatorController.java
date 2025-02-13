package com.vtxlab.demo.helloworld.demo_sb_restful.controller.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.demo.helloworld.demo_sb_restful.model.Operation;
import com.vtxlab.demo.helloworld.demo_sb_restful.service.CalculatorService;

// ! sum -> 1 + 2 -> return 3
// ! subtract -> 1 - 2 -> return -1
// ! multiply -> 1 * 2 -> return 2
// ! divide -> 9 / 3 -> return 3
@RestController // ! @RestController = @Controller + @ResponseBody 
// @Controller -> During Server start -> Create an object of CalculatorController -> put it into context
// 被標記為 @RestController 的控制器類別，這表示它將處理來自外部應用的 HTTP 請求並返回 JSON 或 XML 格式的響應

@RequestMapping(value = "/v1") // 配置了固定路徑/v1，使得外部應用可以通過此路徑訪問 Controller 的API。
public class CalculatorController {
  @Autowired // 使用 @Autowired 將 CalculatorService 注入進來，這實現了依賴注入，讓控制器可以使用 CalculatorService 的功能
  private CalculatorService calculatorService;
  // @Autowired是 Spring Framework 提供的依賴注入機制的標註之一 使用 @Autowired 標註
  // 來自動將相依的 bean（例如 CalculatorService）注入到相應的欄位中 就可以在控制器中使用 CalculatorService 的功能而不需要手動實例化它
  
  // 當一個類別依賴於另一個類別的實例時，我們稱這個被依賴的類別為 bean
  // CalculatorController 類別依賴於 CalculatorService 類別
  // CalculatorController 需要使用 CalculatorService 的功能來執行計算操作
  
  // http://localhost:8082/v1/operation/SUM?x=1&y=2
  @GetMapping(value = "/operation/{operation}") // 設定了一個 GET 請求的路徑 /operation/{operation}，並且定義了參數 operation 作為路徑變數
  @ResponseStatus(HttpStatus.OK) // @ResponseStatus 是 Spring Framework 中的標註之一 用於定義控制器方法的 HTTP 響應狀態碼。
  // 在這裡，您將響應狀態碼設置為 HttpStatus.OK，
  // 表示當這個控制器方法成功執行時，將返回 HTTP 狀態碼 200 OK
  public Integer operate(@PathVariable Operation operation, // 在 operate 方法中，使用 @PathVariable 和 @RequestParam 
      @RequestParam Integer x, @RequestParam Integer y) { // 分別獲取路徑變數 operation 和查詢參數 x、y 的值
    return this.calculatorService.operate(operation, x, y); // 然後調用 CalculatorService 的 operate 方法進行運算
  }
}
