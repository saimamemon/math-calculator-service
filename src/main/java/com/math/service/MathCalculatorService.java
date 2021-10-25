package com.math.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.math.intergration.ServiceIntgImpl;
import com.math.intergration.ServiceIntgInterface;
import com.math.model.HybridExpression;
import com.math.model.Operation;
import com.math.model.OperationFactory;
import com.math.util.CommonUtil;
import com.math.util.Constants;

@Path("/rest")
public class MathCalculatorService
{
	private static Logger logger = LoggerFactory.getLogger(MathCalculatorService.class);
	
	OperationFactory operationFactory = new OperationFactory();
	Operation operation;
	
	@GET
	@Path("/add")
	@Produces(MediaType.APPLICATION_JSON)  
    public Response add(@QueryParam("operand1") Float operand1, @QueryParam("operand2") Float operand2)
    {
		logger.debug("In Add Service -> operand1 : {} | operand2: {}", new Object[] {operand1, operand2});
		JSONObject response = new JSONObject();
		
		try {			
		
			operation = operationFactory.getOperation(Constants.OPERATION_ADD);
		
			response.put(Constants.MATH_RESPONSE_PARAM_RESULT, operation.calculate(operand1, operand2));
			
			logger.debug("response : {}", new Object[] {response});
			
	        return Response.ok(response.toString()).build();
	        
		} catch (Exception e) {
			response.put("error", e.getMessage());
			return Response.status(Response.Status.BAD_REQUEST).entity(response.toString()).build();
		}
    }
	
	@GET
	@Path("/subtract")
	@Produces(MediaType.APPLICATION_JSON)  
    public Response subtract(@QueryParam("operand1") Float operand1, @QueryParam("operand2") Float operand2)
    {
		logger.debug("In Subtract Service -> operand1 : {} | operand2: {}", new Object[] {operand1, operand2});
		
		JSONObject response = new JSONObject();
		
		try {	
			
			operation = operationFactory.getOperation(Constants.OPERATION_SUBTRACT);
		
			response.put(Constants.MATH_RESPONSE_PARAM_RESULT, operation.calculate(operand1, operand2));
			
			logger.debug("response : {}", new Object[] {response});
			
	        return Response.ok(response.toString()).build();
	        
		} catch (Exception e) {
			response.put("error", e.getMessage());
			return Response.status(Response.Status.BAD_REQUEST).entity(response.toString()).build();
		}
		
    }
	
	@GET
	@Path("/multiply")
	@Produces(MediaType.APPLICATION_JSON)  
    public Response multiply(@QueryParam("operand1") Float operand1, @QueryParam("operand2") Float operand2)
    {
		logger.debug("In Multiply Service -> operand1 : {} | operand2: {}", new Object[] {operand1, operand2});
		
		JSONObject response = new JSONObject();
		
		try {			
			
			operation = operationFactory.getOperation(Constants.OPERATION_MULTIPLY);
		
			response.put(Constants.MATH_RESPONSE_PARAM_RESULT, operation.calculate(operand1, operand2));
			
			logger.debug("response : {}", new Object[] {response});
			
	        return Response.ok(response.toString()).build();
	        
		} catch (Exception e) {
			response.put("error", e.getMessage());
			return Response.status(Response.Status.BAD_REQUEST).entity(response.toString()).build();
		}
	      
    }
	
	@GET
	@Path("/divide")
	@Produces(MediaType.APPLICATION_JSON)  
    public Response divide(@QueryParam("operand1") Float operand1, @QueryParam("operand2") Float operand2)
    {
		logger.debug("In Divide Service -> operand1 : {} | operand2: {}", new Object[] {operand1, operand2});
		
		JSONObject response = new JSONObject();
		
		try {			
			
			operation = operationFactory.getOperation(Constants.OPERATION_DIVIDE);
		
			response.put(Constants.MATH_RESPONSE_PARAM_RESULT, operation.calculate(operand1, operand2));
			
			logger.debug("response : {}", new Object[] {response});
			
	        return Response.ok(response.toString()).build();
	        
		} catch (Exception e) {
			response.put("error", e.getMessage());
			return Response.status(Response.Status.BAD_REQUEST).entity(response.toString()).build();
		}
    }
	
	@GET
	@Path("/hybrid")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON) 
    public Response hybrid(HybridExpression expression)
    {
		logger.debug("expression: {}", new Object[] {expression});
		JSONObject response = new JSONObject();
		Float intermediateResult;
		Float result;
		
		try {
			
			ServiceIntgInterface serviceIntg = new ServiceIntgImpl();
			
			CommonUtil.validateOperators(expression);
			
			intermediateResult = serviceIntg.callService(expression.operand1, expression.operand2, expression.operator1);
			result = serviceIntg.callService(intermediateResult, expression.operand3, expression.operator2);
			
			String operationStatement = CommonUtil.getOperationStatement(expression);
			
			response.put(Constants.MATH_RESPONSE_PARAM_OPERATION, operationStatement);
			response.put(Constants.MATH_RESPONSE_PARAM_RESULT, result);
			
			return Response.ok(response.toString()).build();	
			
		}
		catch(Exception e) {
			response.put("error", e.getMessage());
			return Response.status(Response.Status.BAD_REQUEST).entity(response.toString()).build();
		}
    }
	
}
