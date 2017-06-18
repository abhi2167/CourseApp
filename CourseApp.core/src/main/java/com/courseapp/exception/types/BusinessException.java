package com.courseapp.exception.types;

import com.courseapp.service.types.MessageSeverityCode;
import com.courseapp.service.types.SeverityType;

@SuppressWarnings("serial")
public class BusinessException extends ServiceException {

	/**
	 * 
	 */
	public BusinessException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param messageSeverityCode
	 * @param severityType
	 * @param statusCode
	 * @param description
	 * @param sourceExceptionName
	 */
	public BusinessException(MessageSeverityCode messageSeverityCode, SeverityType severityType, String statusCode,
			String description, String sourceExceptionName) {
		super(messageSeverityCode, severityType, statusCode, description, sourceExceptionName);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param messageSeverityCode
	 * @param severityType
	 * @param statusCode
	 * @param description
	 */
	public BusinessException(MessageSeverityCode messageSeverityCode, SeverityType severityType, String statusCode,
			String description) {
		super(messageSeverityCode, severityType, statusCode, description);
		// TODO Auto-generated constructor stub
	}

		
}
