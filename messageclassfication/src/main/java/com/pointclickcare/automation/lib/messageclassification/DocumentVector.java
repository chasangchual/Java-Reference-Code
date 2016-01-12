package com.pointclickcare.automation.lib.messageclassification;

public class DocumentVector {
    //Content represents the document(or any other object) to be clustered
    private String document ;
    
    //represents the tf*idf of  each document
    private TermItem[] termVector  ;
	
    public String getContent() {
		return document;
	}
	
	public void setContent(String content) {
		this.document = content;
	}
}
