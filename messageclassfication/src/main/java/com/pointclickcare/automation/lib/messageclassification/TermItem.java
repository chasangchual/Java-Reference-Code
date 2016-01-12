package com.pointclickcare.automation.lib.messageclassification;

import java.util.ArrayList;
import java.util.List;

public class TermItem {
	private String term ;
	private Float tfidf ;
	private List<Integer> positions = new ArrayList<Integer>();
	
	public String getTerm() {
		return term;
	}
	
	public void setTerm(String term) {
		this.term = term;
	}
	
	public Float getTfidf() {
		return tfidf;
	}

	public void setTfidf(Float tfidf) {
		this.tfidf = tfidf;
	}

	public Integer posSize() {
		return positions.size() ;
	}
	
	public Integer getPos(Integer index) {
		if(index >= 0 && index < positions.size()) {
			return positions.get(index) ;
		}
		
		return -1 ;
	}
	
	public void addPos(Integer pos) {
		positions.add(pos) ;
	}

	@Override
	public String toString() {
		return term + ", " + String.valueOf(tfidf) + ", " + positions.toString() + " " ;
	}
	
	
}
