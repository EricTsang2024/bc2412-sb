package com.vtxlab.demo.helloworld.demo_sb_restful.exception;

public class BusinessException extends RuntimeException{
// 繼承自 RuntimeException 的自訂異常類別 BusinessException
  public BusinessException(String message) { // 呼叫了父類別 RuntimeException 的建構方法來設定異常訊息
    super(message); // 定義了一個帶有字串訊息的建構方法
  } 
}
