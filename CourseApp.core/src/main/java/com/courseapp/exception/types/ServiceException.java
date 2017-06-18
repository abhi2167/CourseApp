package com.courseapp.exception.types;

import com.courseapp.service.types.CourseAppServiceExceptionConstants;
import com.courseapp.service.types.MessageSeverityCode;
import com.courseapp.service.types.SeverityType;

public class ServiceException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8105251766684368746L;
	
	private MessageSeverityCode messageSeverityCode;
	private SeverityType severityType;
	private String statusCode;
	private String description;
	private String sourceExceptionName;
	
	
	/**
	 * 
	 */
	public ServiceException() {
		super();
	}

	
	/**
	 * @param messageSeverityCode
	 * @param severityType
	 * @param statusCode
	 * @param description
	 */
	public ServiceException(MessageSeverityCode messageSeverityCode, SeverityType severityType, String statusCode,
			String description) {
		super();
		this.messageSeverityCode = messageSeverityCode;
		this.severityType = severityType;
		this.statusCode = statusCode;
		this.description = description;
	}


	/**
	 * @param messageSeverityCode
	 * @param severityType
	 * @param statusCode
	 * @param description
	 * @param sourceExceptionName
	 */
	public ServiceException(MessageSeverityCode messageSeverityCode, SeverityType severityType, String statusCode,
			String description, String sourceExceptionName) {
		super();
		this.messageSeverityCode = messageSeverityCode;
		this.severityType = severityType;
		this.statusCode = statusCode;
		this.description = description;
		this.sourceExceptionName = sourceExceptionName;
	}
	
	public MessageSeverityCode getMessageSeverityCode() {
		return messageSeverityCode;
	}
	public void setMessageSeverityCode(MessageSeverityCode messageSeverityCode) {
		this.messageSeverityCode = messageSeverityCode;
	}
	public SeverityType getSeverityType() {
		return severityType;
	}
	public void setSeverityType(SeverityType severityType) {
		this.severityType = severityType;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getSourceExceptionName() {
		return sourceExceptionName;
	}
	public void setSourceExceptionName(String sourceExceptionName) {
		this.sourceExceptionName = sourceExceptionName;
	}
	
		
}
