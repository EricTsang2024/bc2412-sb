package com.vtxlab.demo.helloworld.bc_calculator.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor

public class OperatorDto {
  private String x;
  private String y;
  private String operation;
  private String result;
}
