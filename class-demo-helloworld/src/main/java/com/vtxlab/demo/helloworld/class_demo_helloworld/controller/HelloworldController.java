package com.vtxlab.demo.helloworld.class_demo_helloworld.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@ResponseBody
@RequestMapping(value = "/api/v1")

public class HelloworldController {

  @GetMapping(value = "/helloworld")
  
 public String helloWorld() {
  return "Hello World!";
 }
 
  }
  
  

