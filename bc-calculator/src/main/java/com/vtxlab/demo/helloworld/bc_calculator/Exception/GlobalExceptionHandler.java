package com.vtxlab.demo.helloworld.bc_calculator.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import com.vtxlab.demo.helloworld.bc_calculator.model.dto.ErrorResult;

@RestControllerAdvice // bean
public class GlobalExceptionHandler { //
  @ExceptionHandler(value = {ArithmeticException.class, NumberFormatException.class, InvalidInputException.class})
  @ResponseStatus(value = HttpStatus.BAD_REQUEST) 

  public ErrorResult handleArithmetic(RuntimeException e) { // 創建了一個 ErrorResult 物件來封裝異常訊息
    return new ErrorResult(e.getMessage()); // 可以將異常訊息以統一的格式返回給客戶端
  }
}