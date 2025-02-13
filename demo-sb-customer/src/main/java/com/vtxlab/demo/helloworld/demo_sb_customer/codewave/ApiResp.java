package com.vtxlab.demo.helloworld.demo_sb_customer.codewave;

public class ApiResp<T> {
  // 這個類別使用泛型 T 來表示響應中的數據類型
  private String code;
  // 代表響應代碼、消息和數據的屬性，以及相應的 getter 方法來訪問這些屬性
  private String message;
  private T data;

  // 這是一個靜態方法，用於創建 Builder 物件來構建 ApiResp 物件。
  // 它返回一個新的 Builder<T> 物件
  // 用於建構 ApiResp 物件的建造者
  public static <T> Builder<T> builder() {
    return new Builder<>();
  }

  // 這個構造函數接受一個 Builder 物件作為參數，
  // 並從該 Builder 物件中獲取代碼、消息和數據屬性的值
  public ApiResp(Builder<T> builder) {
    this.code = builder.code;
    this.message = builder.message;
    this.data = builder.data;
  }

  public String getCode() {
    return this.code;
  }

  public String getMessage() {
    return this.message;
  }

  public T getData() {
    return this.data;
  }

  // 這是一個內部 Builder 類別，用於構建 ApiResp 物件。它包含了代表響應代碼、消息和數據的屬性，
  // 以及相應的設置方法（syscode() 和 data()）和 build() 方法來創建 ApiResp 物件
  public static class Builder<T> {
    private String code;
    private String message;
    private T data;

    // 設置方法 syscode()來創建 ApiResp 物件
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

    // 設置方法 data()來創建 ApiResp 物件
    public Builder<T> data(T data) {
      this.data = data;
      return this;
    }

    public ApiResp<T> build() {
      return new ApiResp<>(this);
    }
  }
}