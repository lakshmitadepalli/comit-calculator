package com.comit.calculator.controller;

import java.math.BigDecimal;
import java.math.MathContext;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {
	
	
	@GetMapping("/")
	public String init() {
		System.out.println("Show Calculator!");
		return "calculator";
	}
	@PostMapping("/calculate")
	public ModelAndView show(@RequestParam BigDecimal num1,@RequestParam BigDecimal num2,@RequestParam String operation) {
		System.out.println(num1 + "-" +num2 +"->" +" "+"operation is"+ operation);
		BigDecimal result = BigDecimal.ZERO;
		switch(operation){
		case "+" -> result=num1.add(num2);
		case "-" -> result=num1.subtract(num2);
		case "*" -> result=num1.multiply(num2);
		case "/" -> result=num1.divide(num2,MathContext.DECIMAL128);
		case "%" -> result=num1.remainder(num2);
		default -> throw new RuntimeException("Invalid Operation");
		}
		System.out.println("The result is:"+ result);
		return new ModelAndView( "calculator","res",result);
	}
}
