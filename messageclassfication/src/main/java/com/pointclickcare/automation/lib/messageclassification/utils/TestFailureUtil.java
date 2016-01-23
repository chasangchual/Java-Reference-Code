package com.pointclickcare.automation.lib.messageclassification.utils;

import java.util.List;

import com.pointclickcare.automation.lib.messageclassification.DocumentCollection;
import com.pointclickcare.automation.lib.messageclassification.TermCollection;
import com.pointclickcare.automation.lib.messageclassification.TestFailure;

public class TestFailureUtil {
	public static void dumpPattern(List<TestFailure> failures) {
		for(TestFailure failure : failures) {
			System.out.println(failure.getErrorMsgPattern()) ;
			System.out.println("-------------------------------------------------------------------------------------------------------------") ;
		}
	}
	
	public static void buildTermCollection(List<TestFailure> failures, TermCollection terms) {
		buildTermCollection(failures, terms, false) ;
	}
	
	public static void buildTermCollection(List<TestFailure> failures, TermCollection terms, Boolean dump) {
		terms.clear() ;
		for(TestFailure failure : failures) {
			terms.splitAndAdd(failure.getErrorMsgPattern()) ;
		}
		if(dump)
			terms.dumpToFile("C:\\temp\\terms.txt") ;
	}
	
	public static void buildDocumentCollection(List<TestFailure> failures, DocumentCollection documents) {
		buildDocumentCollection(failures, documents, false) ;
	}
	
	public static void buildDocumentCollection(List<TestFailure> failures, DocumentCollection documents, Boolean dump) {
		documents.clear() ;
		for(TestFailure failure : failures) {
			documents.add(failure.getErrorMsgPattern()) ;
		}
		if(dump)
			documents.dumpToFile("C:\\temp\\documents.txt") ;
	}
}
