package com.vtxlab.demo.helloworld.bc_calculator.service.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;
import org.springframework.stereotype.Service;
import com.vtxlab.demo.helloworld.bc_calculator.Exception.InvalidInputException;
import com.vtxlab.demo.helloworld.bc_calculator.model.dto.OperationDto;
import com.vtxlab.demo.helloworld.bc_calculator.service.CalculatorService;

@Service

public class CalculatorServiceImpl implements CalculatorService {


    public String operate(String x, String y, OperationDto operationDto) {
        String result = switch (operationDto) {
            case ADD -> sum(x, y);
            case SUB -> subtract(x, y);
            case MUL -> multiply(x, y);
            case DIV -> divide(x, y);
            default -> throw new InvalidInputException(
                    "Invalid operation: " + operationDto);
        };
        return result;
    }

    private String sum(String x, String y) {
        try {
            if (x.isEmpty() || y.isEmpty())
                throw new InvalidInputException(
                        "Parameters input cannot be empty");

            Double xValue = Double.parseDouble(x);
            Double yValue = Double.parseDouble(y);
            Double result =
                    BigDecimal.valueOf(xValue).add(BigDecimal.valueOf(yValue))
                            .setScale(5, RoundingMode.HALF_UP).doubleValue();
            return String.valueOf(result);
        } catch (NumberFormatException e) {
            throw new InvalidInputException(
                    "Invalid parameters input. Please input valid numeric parameters");
        }
    }

    private String subtract(String x, String y) {
        try {
            if (x.isEmpty() || y.isEmpty())
                throw new InvalidInputException(
                        "Parameters input cannot be empty");

            Double xValue = Double.parseDouble(x);
            Double yValue = Double.parseDouble(y);
            Double result = BigDecimal.valueOf(xValue)
                    .subtract(BigDecimal.valueOf(yValue))
                    .setScale(5, RoundingMode.HALF_UP).doubleValue();
            return String.valueOf(result);
        } catch (NumberFormatException e) {
            throw new InvalidInputException(
                    "Invalid parameters input. Please input valid numeric parameters");
        }
    }

    private String multiply(String x, String y) {
        try {
            if (x.isEmpty() || y.isEmpty())
                throw new InvalidInputException(
                        "Parameters input cannot be empty");

            Double xValue = Double.parseDouble(x);
            Double yVaule = Double.parseDouble(y);
            Double result = BigDecimal.valueOf(xValue)
                    .multiply(BigDecimal.valueOf(yVaule))
                    .setScale(5, RoundingMode.HALF_UP).doubleValue();
            return String.valueOf(result);
        } catch (NumberFormatException e) {
            throw new InvalidInputException(
                    "Invalid parameters input. Please input valid numeric parameters");
        }
    }

    private String divide(String x, String y) {
        try{
            if(x.isEmpty() || y.isEmpty())
            throw new InvalidInputException("Parameters input cannot be empty");

        BigDecimal xValue = new BigDecimal(x);
        BigDecimal yValue = new BigDecimal(y);
        if (yValue.compareTo(BigDecimal.ZERO) == 0) {
            throw new InvalidInputException(
                    "CalculatorServiceImpl.divide() / zero." + "x=" + x + ", y="
                            + y);
        }
        BigDecimal result = xValue.divide(yValue, 5, RoundingMode.HALF_UP);

        return result.toString();
    } catch (NumberFormatException e) {
        throw new InvalidInputException("Invalid parameters input. Please input valid numeric parameters");
    }
}

}

