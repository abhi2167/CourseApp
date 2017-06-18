package com.courseapp.service.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.courseapp.exception.types.ExecutionContextType;
import com.courseapp.exception.types.ExecutionMessage;
import com.courseapp.service.types.CourseAppHttpResponseType;
import com.courseapp.service.types.MessageSeverityCode;
import com.courseapp.service.types.SeverityType;

@ControllerAdvice
public class CourseAppServiceGeneralException {
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<CourseAppHttpResponseType> handleGeneralException(Exception ex){
		CourseAppHttpResponseType response = new CourseAppHttpResponseType();
		response.setExecutionContext(new ExecutionContextType());
		System.out.println("========== General Excpetion============");
		response.getExecutionContext().getErrors().add(new ExecutionMessage(
				MessageSeverityCode.ERROR, SeverityType.SYSTEM,"" , "FATAL ERROR", "CourseApp"));
		return new ResponseEntity<CourseAppHttpResponseType>(response,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
