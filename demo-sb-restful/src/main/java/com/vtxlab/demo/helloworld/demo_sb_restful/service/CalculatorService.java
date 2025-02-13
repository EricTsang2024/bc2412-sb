package com.vtxlab.demo.helloworld.demo_sb_restful.service;

import org.springframework.stereotype.Service;
import com.vtxlab.demo.helloworld.demo_sb_restful.exception.BusinessException;
import com.vtxlab.demo.helloworld.demo_sb_restful.model.Operation;

@Service
public class CalculatorService {
  public Integer operate(Operation operation, Integer x, Integer y) { //operate 方法接受一個 Operation 枚舉類型的參數
    int result = switch (operation) { // 使用了 Java 12 中的新特性 Switch Expressions 來根據不同的 operation 執行相應的計算
      case SUM -> sum(x, y);
      case SUBTRACT -> subtract(x, y);
      case MULTIPLY -> multiply(x, y);
      case DIVIDE -> divide(x, y);
    };
    System.out.println("operate(): result=" + result);
    return result;
  }

  private Integer sum(Integer x, Integer y) {
    return x + y;
  }

  private Integer subtract(Integer x, Integer y) {
    return x - y;
  }

  private Integer multiply(Integer x, Integer y) {
    return x * y;
  }

  private Integer divide(Integer x, Integer y) {
    System.out.println("divide()");
    if (y == 0) //如果除數 y 為 0，將拋出一個 BusinessException 異常，表示除法運算時遇到除零錯誤
      throw new BusinessException(
          "CalculatorService.divide() / zero." + "x=" + x + ",y=" + y);
    return x / y;
  }
}