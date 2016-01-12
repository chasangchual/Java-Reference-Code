package com.pointclickcare.automation.lib.messageclassification;

import java.util.ArrayList;
import java.util.List;

public class DocumentSimilarityTable {
	List<List<Float>> simility = new ArrayList<List<Float>>() ;
	
	public DocumentSimilarityTable(Integer size)
	{
		// Clear current table
		for(int i = 0 ; i < simility.size(); i++) {
			simility.get(i).clear() ;
		}
		simility.clear() ;
		
		// Reserve table space
		for(int i = 0 ; i < size; i++) {
			simility.add(new ArrayList<Float>()) ;
		}
	}
	
	public void set(Integer row, Integer col, Float value) {
		List<Float> r = simility.get(row) ;
		r.set(col, value) ;
		
		List<Float> c = simility.get(col) ;
		c.set(row, value) ;
	}
	
	public void calculate(String[] strings) {
		for(int i = 0 ; i < strings.length; i++) {
			for(int k = i ; k < strings.length; k++) {
				if(i != k) {
					set(i,k, calculateSimiliarity(strings[i], strings[k])) ;
				}
			}
		}
	}
	
	public Float calculateSimiliarity(String str1, String str2)
	{
		return 0.0f ;
	}
}
