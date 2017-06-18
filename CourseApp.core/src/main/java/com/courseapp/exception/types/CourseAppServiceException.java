package com.courseapp.exception.types;

import com.courseapp.service.types.CourseAppHttpResponseType;

@SuppressWarnings("serial")
public class CourseAppServiceException extends Exception{
	
	private CourseAppHttpResponseType response;

	public CourseAppHttpResponseType getResponse() {
		return response;
	}

	public void setResponse(CourseAppHttpResponseType response) {
		this.response = response;
	}

	
	/**
	 * 
	 */
	public CourseAppServiceException() {
		super();
	}

	/**
	 * @param response
	 */
	public CourseAppServiceException(CourseAppHttpResponseType response) {
		super();
		this.response = response;
	}
	
	
	
}
