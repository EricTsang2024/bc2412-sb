package com.vtxlab.demo.helloworld.demo_sb_restful.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.vtxlab.demo.helloworld.demo_sb_restful.model.Cat;

public interface CatOperation {

    @PostMapping(value = "/cat")
  public Cat createCat(@RequestBody Cat cat);

  @GetMapping(value = "/cats")
  public List<Cat> getCats();

    // Get Cat By id
  // http://localhost:8082/cat?id=1     根据提供的id获取对应的猫
  // 以 ? 開頭，多個參數之間使用 & 進行分隔
  @GetMapping(value = "/cat")
  public Cat getCat(@RequestParam Long id);

  @DeleteMapping(value = "/cat")
  public Boolean deleteCat(@RequestParam Long id);

  @PutMapping(value = "/cat")
  public Boolean updateCat(@RequestParam Long id, @RequestBody Cat cat);

  @PatchMapping(value = "/cat/name/{name}")
  public Boolean patchCatName(@RequestParam Long id, @PathVariable String name);
}

