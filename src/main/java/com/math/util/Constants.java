package com.math.util;

public interface Constants {
	public static final String MATH_RESPONSE_PARAM_RESULT = "result";
	public static final String MATH_RESPONSE_PARAM_ERROR = "error";
	public static final String MATH_RESPONSE_PARAM_OPERATION = "operation";
	
	public static final String OPERATION_ADD = "add";
	public static final String OPERATION_SUBTRACT = "subtract";
	public static final String OPERATION_MULTIPLY = "multiply";
	public static final String OPERATION_DIVIDE = "divide";
	
	public static final String MATHEMATICAL_CALCULATOR_ENDPOINT="http://localhost:9001/MathematicalCalculator/rest/{operator}?operand1={operand1}&operand2={operand2}";
	
}