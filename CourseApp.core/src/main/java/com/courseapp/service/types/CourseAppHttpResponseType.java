package com.courseapp.service.types;

import java.util.List;

import com.courseapp.exception.types.ExecutionContextType;

public class CourseAppHttpResponseType {

	private ExecutionContextType executionContext;
	private List<Topic> topics;
	private List<Course> courses;
	
	public ExecutionContextType getExecutionContext() {
		return executionContext;
	}
	public void setExecutionContext(ExecutionContextType executionContext) {
		this.executionContext = executionContext;
	}
	public List<Topic> getTopics() {
		return topics;
	}
	public void setTopics(List<Topic> topics) {
		this.topics = topics;
	}
	public List<Course> getCourses() {
		return courses;
	}
	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}
	
	public CourseAppHttpResponseType() {
		super();
	}
	
	public CourseAppHttpResponseType(ExecutionContextType executionContext, List<Topic> topics,
			List<Course> courses) {
		super();
		this.executionContext = executionContext;
		this.topics = topics;
		this.courses = courses;
	}
	
	
	
}
