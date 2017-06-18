package com.courseapp.service.types;

public enum CourseAppServiceExceptionConstants {
	NO_TOPICS_FOUND("1000","No Topics Found"),
	NO_COURSES_FOUND("2000","No Courses Found");

	private String statusCode;
	private String description;
	
	private CourseAppServiceExceptionConstants(String statusCode,String description){
		this.statusCode=statusCode;
		this.description=description;
	}
	
	public String getStatusCode() {
		return statusCode;
	}
	
	public String getDescription(){
		return description;
	}
}
