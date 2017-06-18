package com.courseapp.exception.types;

import com.courseapp.service.types.MessageSeverityCode;
import com.courseapp.service.types.SeverityType;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ExecutionMessage {

	private SeverityType type;
	private MessageSeverityCode severity;
	private String statusCode;
	private String description;
	private String sourceExceptionName;


	public MessageSeverityCode getSeverity() {
		return severity;
	}

	public void setSeverity(MessageSeverityCode severity) {
		this.severity = severity;
	}

	@JsonProperty("type")
	public SeverityType getSeverityType() {
		return type;
	}

	public void setSeverityType(SeverityType severityType) {
		this.type = severityType;
	}
	
	@JsonProperty("code")
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
	
	@JsonProperty("source")
	public String getSourceExceptionName() {
		return sourceExceptionName;
	}

	public void setSourceExceptionName(String sourceExceptionName) {
		this.sourceExceptionName = sourceExceptionName;
	}

	public ExecutionMessage() {
		super();
	}

	public ExecutionMessage(MessageSeverityCode severity, SeverityType severityType, String statusCode,
			String description, String sourceExceptionName) {
		super();
		this.severity = severity;
		this.type = severityType;
		this.statusCode = statusCode;
		this.description = description;
		this.sourceExceptionName = sourceExceptionName;
	}

	@Override
	public String toString() {
		return "ExecutionMessage [severity=" + severity + ", severityType=" + type
				+ ", statusCode=" + statusCode + ", description=" + description + ", sourceExceptionName="
				+ sourceExceptionName + "]";
	}

}
