package com.vtxlab.demo.helloworld.demo_sb_customer.codewave;

// 這段程式碼使用了建造者模式，通過 Builder 類別來幫助構建複雜的 ApiResp 物件，並且可以靈活地設置其屬性值
public class ApiResp<T> {
  // 這個類別使用泛型 T, T代表數據的型別。
  private String code;
  // 代表三個私有屬性、消息和數據的屬性
  private String message;
  private T data;

  // 這是一個靜態方法，用於創建 Builder 物件來構建 ApiResp 物件。
  // 它返回一個新的 Builder<T> 物件
  // 用於建構 ApiResp 物件的建造者
  public static <T> Builder<T> builder() {
    return new Builder<>();
  }

  public ApiResp() {
    
  }

  // 這個構造函數接受一個 Builder 物件作為參數，
  // 使用 Builder 物件中的值, 初始化 ApiResp 物件
  public ApiResp(Builder<T> builder) {
    this.code = builder.code;
    this.message = builder.message;
    this.data = builder.data;
  // 將 Builder 物件中的代碼、訊息和數據值設置到 ApiResp 物件中
  }

  // 相應的 getter 方法來獲取 ApiResp 物件中的代碼、訊息和數據值
  public String getCode() {
    return this.code;
  }

  public String getMessage() {
    return this.message;
  }

  public T getData() {
    return this.data;
  }

  // 內部靜態類別 Builder<T>，用於構建 ApiResp 物件。
  public static class Builder<T> {
    private String code;
    private String message;
    private T data;

    // 設置 Builder 物件中的代碼和訊息屬性，使用 SysCode 物件的值
    public Builder<T> syscode(SysCode sysCode) {
      this.code = sysCode.getCode();
      this.message = sysCode.getMessage();
      return this;
    }

    // public Builder<T> code(String code) {
    //   this.code = code;
    //   return this;
    // }

    // public Builder<T> message(String message) {
    //   this.message = message;
    //   return this;
    // }

    // 設置 Builder 物件中的數據屬性
    public Builder<T> data(T data) {
      this.data = data;
      return this;
    }

    // 建造 ApiResp 物件，使用 Builder 物件中的值來初始化 ApiResp
    public ApiResp<T> build() {
      return new ApiResp<>(this);
    }
  }
}