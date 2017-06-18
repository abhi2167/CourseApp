package com.courseapp.exception.types;

import java.util.ArrayList;
import java.util.List;

public class ExecutionContextType {
	private List<ExecutionMessage> errors;
	private List<ExecutionMessage> warnings;
	private List<ExecutionMessage> infos;
	
	public List<ExecutionMessage> getErrors() {
		if(errors == null)
			this.errors = new ArrayList<ExecutionMessage>();
		return errors;
	}
	
	public List<ExecutionMessage> getWarnings() {
		
		return warnings;
	}
	
	public List<ExecutionMessage> getInfos() {
		return infos;
	}
	
	public ExecutionContextType() {
		super();
	}
	public ExecutionContextType(List<ExecutionMessage> errors, List<ExecutionMessage> warnings,
			List<ExecutionMessage> infos) {
		super();
		this.errors = errors;
		this.warnings = warnings;
		this.infos = infos;
	}
	
	@Override
	public String toString() {
		return "ExecutionContextType [errors=" + errors + ", warnings=" + warnings + ", infos=" + infos + "]";
	}
	
	
	
}
