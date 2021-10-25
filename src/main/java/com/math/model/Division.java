package com.math.model;

public class Division implements Operation{

	@Override
	public Float calculate(Float operand1, Float operand2) throws Exception {
		if(operand2==0) {
			throw new Exception("Cannot be divided by 0");
		}
		return operand1/operand2;
	}

}
