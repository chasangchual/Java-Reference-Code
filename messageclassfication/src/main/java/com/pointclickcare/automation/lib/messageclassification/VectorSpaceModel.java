package com.pointclickcare.automation.lib.messageclassification;

public class VectorSpaceModel {
	private static final String SPLIT = "\\s+" ;
	
	public static float findTFIDF(String document, String term) {
		TermCollection terms = TermCollection.getInstance() ;
		
		float tf = findTermFrequency(document, term) ;
		return tf * terms.getWeight(term) ;
	}
	
	private static float findTermFrequency(String document, String term) {
		String[] pasrseds = document.split(SPLIT) ;
		Integer count = 0 ; 
		for(String parsed : pasrseds) {
			if(parsed.equalsIgnoreCase(term)) {
				count ++ ;
			}
		}
		return ((float)count / (float)pasrseds.length) ;
	}
}
