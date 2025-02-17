package com.vtxlab.demo.helloworld.bc_calculator.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import com.vtxlab.demo.helloworld.bc_calculator.model.dto.OperatorDto;

public interface CalculatorOperation {

  @GetMapping(value = "/operation")
    OperatorDto calculateUsingQueryParams (@RequestParam String x, @RequestParam String y, 
    @RequestParam String operation);

    @GetMapping(value = "/operation/{x}/{y}/{operation}")
    OperatorDto calculateUsingPathParams (@PathVariable String x, @PathVariable String y,
    @PathVariable String operation);

    @PostMapping(value = "/operation")
    OperatorDto calculateUsingJsonPayload(@RequestBody OperatorDto operatorDto);


}
