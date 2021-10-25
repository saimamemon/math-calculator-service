package com.math.intergration;

import org.apache.http.HttpStatus;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.request.HttpRequest;
import com.math.util.Constants;

public class ServiceIntgImpl implements ServiceIntgInterface{
	
	private static Logger logger = LoggerFactory.getLogger(ServiceIntgImpl.class);

	@Override
	public Float callService(Float operand1, Float operand2, String operator) throws Exception {
		logger.debug("In callService --> operand1: {} | operand2 : {} | operator: {}", new Object[] {operand1, operand2, operator});
		
		String endpoint = Constants.MATHEMATICAL_CALCULATOR_ENDPOINT;
		endpoint = endpoint.replace("{operator}", operator.toLowerCase());
		endpoint = endpoint.replace("{operand1}", operand1.toString());
		endpoint = endpoint.replace("{operand2}", operand2.toString());
		
		logger.debug("endpoint : {}", new Object[] {endpoint});
		
		HttpRequest req = null;
		
		req = Unirest.get(endpoint);
		//.routeParam("operand1", operand1.toString())
		//.routeParam("operand2", operand2.toString());
		
		logger.debug("request : {}", new Object[] {req});
		
		
		HttpResponse<JsonNode> response = req.asJson();
		JSONObject responseJSON = new JSONObject(response.getBody().toString());
		if(response.getStatus()==HttpStatus.SC_OK) {			
			return responseJSON.getFloat(Constants.MATH_RESPONSE_PARAM_RESULT);
		}
		else {
			throw new Exception("Exception in " + operator + " Integration - " + responseJSON.getString(Constants.MATH_RESPONSE_PARAM_ERROR));
		}
	}

}
