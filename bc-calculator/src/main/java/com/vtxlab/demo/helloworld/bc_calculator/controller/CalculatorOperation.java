package com.vtxlab.demo.helloworld.bc_calculator.controller;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import com.vtxlab.demo.helloworld.bc_calculator.model.dto.OperatorDto;

public interface CalculatorOperation {

  @GetMapping(value = "/operation")
  @ResponseStatus(HttpStatus.OK)
    OperatorDto calculateUsingQueryParams (@RequestParam String x, @RequestParam String y, 
    @RequestParam String operation);

    @GetMapping(value = "/operation/{x}/{y}/{operation}")
    @ResponseStatus(HttpStatus.OK)
    OperatorDto calculateUsingPathParams (@PathVariable String x, @PathVariable String y,
    @PathVariable String operation);

    @PostMapping(value = "/operation")
    @ResponseStatus(HttpStatus.OK)
    OperatorDto calculateUsingJsonPayload(@RequestBody OperatorDto operatorDto);


}
