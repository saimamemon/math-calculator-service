package com.math.util;

import com.math.model.HybridExpression;

public class CommonUtil {

	public static String getOperationStatement(HybridExpression expression) {
		
		String op1 = getOperatorSign(expression.operator1);
		String op2 = getOperatorSign(expression.operator2);
		
		String operation = "((" + expression.operand1 + " " + op1 + " " + expression.operand2 + ") " + op2 + " " + expression.operand3 + ")";
		
		return operation;
		
	}

	private static String getOperatorSign(String operator) {
		switch(operator.toLowerCase()) {
		case Constants.OPERATION_ADD:
			return "+";
		case Constants.OPERATION_SUBTRACT:
			return "-";
		case Constants.OPERATION_MULTIPLY:
			return "*";
		case Constants.OPERATION_DIVIDE:
			return "/";
		case "default":
			return null;
		}
		return null;
	}

	public static void validateOperators(HybridExpression expression) throws Exception {
		if(getOperatorSign(expression.operator1)==null || getOperatorSign(expression.operator2)==null)
			throw new Exception("Invalid operator! Following are valid operators: add, subtract, multiply and divide");
	}

}
