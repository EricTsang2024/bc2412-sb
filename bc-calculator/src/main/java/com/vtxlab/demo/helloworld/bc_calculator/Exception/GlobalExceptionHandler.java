package com.vtxlab.demo.helloworld.bc_calculator.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.vtxlab.demo.helloworld.bc_calculator.model.dto.ErrorResult;

@RestControllerAdvice // bean
public class GlobalExceptionHandler { //
  @ExceptionHandler(
      value = {ArithmeticException.class, InvalidInputException.class})
      // 指定了該特定異常處理器方法要處理的異常類型
      // ArithmeticException 和 BusinessException 這兩種異常類型
      // Spring Framework 將會調用這個異常處理器方法來處理這些異常
  @ResponseStatus(value = HttpStatus.BAD_REQUEST) 
  // 使用 @ResponseStatus 標註來指定當特定異常發生時要返回的 HTTP 狀態碼
  // 返回的是 HttpStatus.BAD_REQUEST 狀態碼
  public ErrorResult handleArithmetic(RuntimeException e) { // 創建了一個 ErrorResult 物件來封裝異常訊息
    return new ErrorResult(e.getMessage()); // 可以將異常訊息以統一的格式返回給客戶端
  }
}