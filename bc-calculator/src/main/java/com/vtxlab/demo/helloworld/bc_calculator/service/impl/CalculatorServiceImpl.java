package com.vtxlab.demo.helloworld.bc_calculator.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import com.vtxlab.demo.helloworld.bc_calculator.Exception.InvalidInputException;
import com.vtxlab.demo.helloworld.bc_calculator.model.dto.OperationDto;
import com.vtxlab.demo.helloworld.bc_calculator.service.CalculatorService;



public class CalculatorServiceImpl implements CalculatorService {


    public String operate(String x, String y, OperationDto operationDto) {
        String result = switch (operationDto) {
            case ADD -> sum(x, y);
            case SUB -> subtract(x, y);
            case MUL-> multiply(x, y);
            case DIV -> divide(x, y);
             default -> throw new InvalidInputException(
                "Invalid operation: " + operationDto);
        };
        return result;
    }

    private String sum(String x, String y) {
        Double xValue = Double.parseDouble(x);
        Double yValue = Double.parseDouble(y);
        Double result = BigDecimal.valueOf(xValue)
                .add(BigDecimal.valueOf(yValue))
                .setScale(5, RoundingMode.HALF_UP)
                .doubleValue();
        return String.valueOf(result);
    }

    private String subtract(String x, String y) {
        Double xValue = Double.parseDouble(x);
        Double yValue = Double.parseDouble(y);
        Double result = BigDecimal.valueOf(xValue)
                .subtract(BigDecimal.valueOf(yValue))
                .setScale(5, RoundingMode.HALF_UP
                ).doubleValue();
        return String.valueOf(result);
    }

    private String multiply(String x, String y) {
        Double xValue = Double.parseDouble(x);
        Double yVaule = Double.parseDouble(y);
        Double result = BigDecimal.valueOf(xValue)
                .multiply(BigDecimal.valueOf(yVaule))
                .setScale(5, RoundingMode.HALF_UP)
                .doubleValue();
        return String.valueOf(result);
    }

    private String divide(String x, String y) {
        System.out.println("divide()");
        if (y.equals("0.0"))
            throw new InvalidInputException("CalculatorService.divide() /zero."
                    + "x=" + x + ", y=" + y);
        Double xValue = Double.parseDouble(x);
        Double yVaule = Double.parseDouble(y);
        Double result = BigDecimal.valueOf(xValue)
                .divide(BigDecimal.valueOf(yVaule))
                .setScale(5, RoundingMode.HALF_UP)
                .doubleValue();
        return String.valueOf(result);
    }
}


