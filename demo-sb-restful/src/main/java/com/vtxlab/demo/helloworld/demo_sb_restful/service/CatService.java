package com.vtxlab.demo.helloworld.demo_sb_restful.service;

import org.springframework.stereotype.Service;
import com.vtxlab.demo.helloworld.demo_sb_restful.model.Cat;
import com.vtxlab.demo.helloworld.demo_sb_restful.model.CatDatabase;

// Person.class -> weight/height -> bmi()

@Service // CatService 類別被標記為 @Service，
// 這表示它是 Spring Framework 中的一個服務類別，通常用於處理業務邏輯

public class CatService { // 將貓咪對象放入貓咪數據庫中
  // stateless object, can be a bean
  // CatService 是一個狀態無關（stateless）的物件，這意味著它可以被視為一個 bean，並且在應用程序中可以共享

  // 在無狀態的情況下，系統不會保存用戶的狀態信息，每個請求都被獨立處理，並不會影響到其他請求或資源。
  // 這樣的系統更容易擴展和維護，因為不需要管理用戶狀態，並且可以更好地處理高流量的情況

  // 有狀態（stateful），可能會導致以下情況
  // 共享資源問題：當一個物件具有狀態時，多個執行緒或用戶可能同時修改這個物件的狀態。這可能導致競爭條件（race condition）和不一致性的問題，因為每個執行緒或用戶都可以改變物件的狀態。
  // 狀態管理困難：具有狀態的物件需要在不同的方法調用之間保持狀態，這可能導致狀態管理變得複雜。特別是在多執行緒環境下，要確保狀態的一致性可能需要額外的同步處理。
  // 生命週期管理困難：具有狀態的物件需要適當地管理其生命週期，包括初始化、清理和釋放資源。如果未正確管理這些生命週期，可能會導致資源洩漏或記憶體洩漏等問題。
  
  public boolean put(Cat cat) { // put 方法用於將傳入的貓咪對象放入 CatDatabase.HOME 數組中的第一個空位置。
    for (int i = 0; i < CatDatabase.HOME.length; i++) {
      if (CatDatabase.HOME[i] == null) { // 如果找到空位置，則將貓咪對象放入該位置並返回 true，否則返回 false。
        CatDatabase.HOME[i] = cat;
        return true;
      }
    }
    return false;
  }
}