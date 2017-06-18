package com.courseapp.service.types;

import java.util.List;

public class CourseAppHttpRequestType {
	
	private List<Topic> topics;
	private List<Course> courses;
	private String operation;
	private String topicId;
	private String topicName;

	/**
	 * 
	 */
	public CourseAppHttpRequestType() {
		super();
	}
	
	
	/**
	 * @param topics
	 * @param courses
	 */
	public CourseAppHttpRequestType(List<Topic> topics, List<Course> courses) {
		super();
		this.topics = topics;
		this.courses = courses;
	}


	/**
	 * @param topics
	 * @param courses
	 * @param operation
	 */
	public CourseAppHttpRequestType(List<Topic> topics, List<Course> courses, String operation) {
		super();
		this.topics = topics;
		this.courses = courses;
		this.operation = operation;
	}
	
	
	public String getTopicId() {
		return topicId;
	}


	public void setTopicId(String topicId) {
		this.topicId = topicId;
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
	public String getOperation() {
		return operation;
	}
	public void setOperation(String operation) {
		this.operation = operation;
	}

	
	public String getTopicName() {
		return topicName;
	}


	public void setTopicName(String topicName) {
		this.topicName = topicName;
	}


	@Override
	public String toString() {
		return "CourseAppHttpRequestType [topics=" + topics + ", courses=" + courses + ", operation=" + operation
				+ ", topicId=" + topicId + "]";
	}
	
	
	
}
