package com.vtxlab.demo.helloworld.bc_calculator.controller.impl;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.vtxlab.demo.helloworld.bc_calculator.controller.CalculatorOperation;
import com.vtxlab.demo.helloworld.bc_calculator.model.dto.OperationDto;
import com.vtxlab.demo.helloworld.bc_calculator.model.dto.OperatorDto;
import com.vtxlab.demo.helloworld.bc_calculator.service.impl.CalculatorServiceImpl;
import lombok.AllArgsConstructor;

@AllArgsConstructor
@RestController
public class CalculatorController implements CalculatorOperation{

   @Autowired
    private CalculatorServiceImpl calculatorServiceImpl;

    @Override
    public OperatorDto calculateUsingQueryParams(@RequestParam String x, @RequestParam String y, 
    @RequestParam String operation) {    
    OperationDto operationDto = OperationDto.fromString(operation);
    String result = this.calculatorServiceImpl.operate(x, y, operationDto);
    return new OperatorDto(x, y, operation, result);
}
    
    @Override
    @PostMapping("/operation")
    public String calculateUsingJsonPayload(@RequestBody OperatorDto operatorDto) {
        OperationDto operationDto = OperationDto.fromString(operatorDto.getOperation());
        Double finalresult = calculatorService.operate(xValue, yValue, operationDto);
        return String.format("%.5f", finalresult);
    }

    @Override
    @GetMapping("/operation/{x}/{y}/{operation}")
    public OperatorDto calculateUsingPathParams(@PathVariable String x, @PathVariable String y,
     @PathVariable String operation) {
        OperationDto operationDto = OperationDto.fromString(operation);
        String result = this.calculatorServiceImpl.operate(x, y, operationDto);
        return new OperatorDto(x, y, operation, result);
    }
}
