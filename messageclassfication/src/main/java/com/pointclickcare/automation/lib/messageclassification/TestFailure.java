package com.pointclickcare.automation.lib.messageclassification;

public class TestFailure {
	private int failureId = -1;
	private String exception;
	private String errorMsgPattern;
	private String lastClass;
	private String lastMethod;
	private int lastLine;
  
	public int getFailureId() {
		return failureId;
	}
	public void setFailureId(int failureId) {
		this.failureId = failureId;
	}
	public String getException() {
		return exception;
	}
	public void setException(String exception) {
		this.exception = exception;
	}
	public String getErrorMsgPattern() {
		return errorMsgPattern;
	}
	public void setErrorMsgPattern(String errorMsgPattern) {
		this.errorMsgPattern = errorMsgPattern;
	}
	public String getLastClass() {
		return lastClass;
	}
	public void setLastClass(String lastClass) {
		this.lastClass = lastClass;
	}
	public String getLastMethod() {
		return lastMethod;
	}
	public void setLastMethod(String lastMethod) {
		this.lastMethod = lastMethod;
	}
	public int getLastLine() {
		return lastLine;
	}
	public void setLastLine(int lastLine) {
		this.lastLine = lastLine;
	}
}
