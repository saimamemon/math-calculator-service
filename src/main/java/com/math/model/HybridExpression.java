package com.math.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name = "HybridExpression")
public class HybridExpression {

	public Float operand1;
	public Float operand2;
	public Float operand3;
	public String operator1;
	public String operator2;
	public Float result;
	
	public HybridExpression() {} // JAXB needs this
	 
    public HybridExpression(Float operand1, Float operand2, Float operand3, String operator1, String operator2, Float result) {
        this.operand1 = operand1;
        this.operand2 = operand2;
        this.operand3 = operand3;
        this.operator1 = operator1;
        this.operator2 = operator2;
        this.result = result;
    }

	@Override
	public String toString() {
		return "HybridExpression [operand1=" + operand1 + ", operand2=" + operand2 + ", operand3=" + operand3 + ", operator1="
				+ operator1 + ", operator2=" + operator2 + ", result=" + result + "]";
	}
    
    

}
