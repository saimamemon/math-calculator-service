package com.math.model;

public class Multiplication implements Operation{

	@Override
	public Float calculate(Float operand1, Float operand2) {
		return operand1*operand2;
	}

}
