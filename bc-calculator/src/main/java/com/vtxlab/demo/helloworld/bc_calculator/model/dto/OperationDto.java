package com.vtxlab.demo.helloworld.bc_calculator.model.dto;

import com.vtxlab.demo.helloworld.bc_calculator.Exception.InvalidInputException;
import lombok.Getter;

@Getter
public enum OperationDto {
  ADD, SUB, MUL, DIV,;

  public static OperationDto fromString(String operation) {
        return switch (operation.toLowerCase()) {
            case "add" -> OperationDto.ADD;
            case "sub" -> OperationDto.SUB;
            case "mul" -> OperationDto.MUL;
            case "div" -> OperationDto.DIV;
            default -> throw new InvalidInputException(
                    "Invalid operation: " + operation);
        };
    }
}

