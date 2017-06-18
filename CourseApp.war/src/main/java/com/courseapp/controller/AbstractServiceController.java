package com.courseapp.controller;

import org.apache.log4j.MDC;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.courseapp.exception.types.BusinessException;
import com.courseapp.exception.types.CourseAppServiceException;
import com.courseapp.exception.types.ExecutionContextType;
import com.courseapp.exception.types.ExecutionMessage;
import com.courseapp.service.types.CourseAppHttpResponseType;


public abstract class AbstractServiceController {

	@ExceptionHandler(CourseAppServiceException.class)
	public ResponseEntity<CourseAppHttpResponseType> CourseAppServiceExceptionHandler(CourseAppServiceException ex){
		System.out.println("Course App Service Excpetion ===============");
		return new ResponseEntity<CourseAppHttpResponseType>(ex.getResponse(),HttpStatus.OK);
	}
	
	protected ResponseEntity<CourseAppHttpResponseType> handleBusinessException(CourseAppHttpResponseType response, BusinessException ex) throws CourseAppServiceException{
		if(response == null){
			response = new CourseAppHttpResponseType();
		}
		ExecutionMessage executionMessage = new ExecutionMessage();
		executionMessage.setStatusCode(ex.getStatusCode());
		executionMessage.setDescription(ex.getDescription());
		executionMessage.setSeverity(ex.getMessageSeverityCode());
		executionMessage.setSeverityType(ex.getSeverityType());
		executionMessage.setSourceExceptionName(ex.getSourceExceptionName());
		
		if(response.getExecutionContext() == null){
			response.setExecutionContext(new ExecutionContextType());
		}
		if(ex.getMessageSeverityCode().toString().equalsIgnoreCase("ERROR")){
			response.getExecutionContext().getErrors().add(executionMessage);
		} else if(ex.getMessageSeverityCode().toString().equalsIgnoreCase("WARNING")){
			response.getExecutionContext().getWarnings().add(executionMessage);
		} else if(ex.getMessageSeverityCode().toString().equalsIgnoreCase("INFO")){
			response.getExecutionContext().getInfos().add(executionMessage);
		}
		throw new CourseAppServiceException(response);
	}
	
	protected void handleUnknownException(CourseAppHttpResponseType response,Exception e){
		
	}
	
	protected void setMDC(String correlationId){
		if(correlationId !=null)
			MDC.put("correlationId", correlationId);
	}
	
	protected void resetMDC(){
		MDC.remove("correlationId");
	}
}
