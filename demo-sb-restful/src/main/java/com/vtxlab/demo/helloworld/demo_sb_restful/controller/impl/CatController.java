package com.vtxlab.demo.helloworld.demo_sb_restful.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;
import com.vtxlab.demo.helloworld.demo_sb_restful.controller.CatOperation;
import com.vtxlab.demo.helloworld.demo_sb_restful.model.Cat;
import com.vtxlab.demo.helloworld.demo_sb_restful.model.CatDatabase;
import com.vtxlab.demo.helloworld.demo_sb_restful.service.CatService;

// ! RESTful API -> GET/POST/DELETE/PUT/PATCH
// Control single resource by GET/POST/DELETE/PUT/PATCH

// Controller -> The ways to control Cat resource
// insert, update, delete, select

@Controller // 标记此类为Spring Web应用程序的控制器 这些方法映射到特定的网络地址上
@ResponseBody // @ResponseBody 的功能是將方法的回傳值轉換為 HTTP 回應的主體（body）並進行序列化，然後將其發送回給客戶端
// 當方法的回傳值需要返回給客戶端時，Spring Framework會自動將這個回傳值序列化為 JSON、XML 或其他格式
// 然後將其包裝在 HTTP 回應的主體中，以便客戶端能夠正確解析和處理



public class CatController implements CatOperation{
  // Field injection
  @Autowired
  private CatService catService;

    // Constructor Injection
  // @Autowired
  // public CatController(CatService catService) {
  //   this.catService = catService;
  // }

  @Override
  public Cat createCat(Cat cat) {
    if (this.catService.put(cat)) // Null pointer exception?
      return cat;
    return null;
  }


  // Arrays.asList() vs List.of() vs new ArrayList<>()

  // Get All Cats

  public List<Cat> getCats() { // 返回存储在CatDatabase.HOME中的所有猫的列表
    return List.of(CatDatabase.HOME); // List.of(CatDatabase.HOME)会创建一个包含CatDatabase.HOME字段值的新列表。
  } // 如果HOME字段是空的，这将返回一个空列表

  // Get Cat By id
  // http://localhost:8082/cat?id=1     根据提供的id获取对应的猫
  // Deserialization

  public Cat getCat(Long id) {
    new Cat(id, null, null);
    return CatDatabase.find(id).orElse(null);
  }

  // http://localhost:8082/cat?id=1

  public Boolean deleteCat(Long id) { 
    return CatDatabase.delete(id); // 返回一个布尔值，表示删除操作是否成功
  }

  // HashMap.put() -> if exists, override, otherwise, create new {当需要更新猫的全部信息（包括所有字段）}
  
  public Boolean updateCat(Long id, Cat cat) {
    return CatDatabase.update(id, cat); // 返回一个布尔值，表示更新操作是否成功
  }

  // 根据提供的id和新的猫名更新对应的猫 {当只需要修改某个特定的字段（如名字）}
  public Boolean patchCatName(Long id, String name) { //  (PathVariable)表示这是一个路径变量（体变量）
    return CatDatabase.patchName(id, name); // 
  }

  // 
}