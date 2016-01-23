package com.pointclickcare.automation.lib.messageclassification;

import java.util.ArrayList;
import java.util.List;

public class Centroid {
	private List<DocumentVector> groupedDocuments = new ArrayList<>() ;
	
	public void clear() {
		groupedDocuments.clear() ;
	}
	
	public int size() {
		return groupedDocuments.size() ;
	}
	
	public void add(DocumentVector vector) {
		groupedDocuments.add(vector) ;
	}
	
	public DocumentVector get(int index) {
		if(index >= 0 && index < groupedDocuments.size()) {
			return groupedDocuments.get(index) ;
		}
		
		return null ;
	}
}
