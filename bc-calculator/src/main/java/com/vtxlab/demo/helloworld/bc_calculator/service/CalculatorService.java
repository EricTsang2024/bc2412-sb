package com.vtxlab.demo.helloworld.bc_calculator.service;

import com.vtxlab.demo.helloworld.bc_calculator.model.dto.OperationDto;

public interface CalculatorService {
  String operate(String x, String y, OperationDto operationDto);

}
