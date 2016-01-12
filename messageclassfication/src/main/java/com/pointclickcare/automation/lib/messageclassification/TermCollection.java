package com.pointclickcare.automation.lib.messageclassification;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * 
 * @author Ethan Cha
 *
 */
public class TermCollection {
	private SortedMap<String, Float> terms = new TreeMap<String, Float>() ;
	
	private static TermCollection instance = null ;
	final static Charset ENCODING = StandardCharsets.UTF_8;
	
	public synchronized static TermCollection getInstance() {
		if(instance == null) {
			instance = new TermCollection() ;
		}
		return instance ;
	}
	
	private TermCollection() {
		
	}
	
	public void clear() {
		terms.clear() ;
	}
	
	public Integer size() {
		return terms.size() ;
	}
	
	public void add(String term) {
		terms.put(term, 0.0f) ;
	}
	
	public void setWeithg(String term, Float f) {
		terms.put(term, f) ;
	}
	
	public void splitAndAdd(String str)
	{
		// StringTokenizer tokenizer = new StringTokenizer(str) ;
		if(str != null && str.trim().length() > 0) {
			String[] words = str.split("\\s+|/|::|//|[|](|)|,") ;
			for(String word : words) {
				add(word) ;
			}
		}
	}
	
	public String get(Integer index) {
		if(index >= 0 && index < terms.size()) {
			return (String)(terms.keySet().toArray())[index] ;
		} else {
			return null ;
		}
	}
	
	public Float getWeight(Integer index) {
		if(index >= 0 && index < terms.size()) {
			return getWeight(get(index)) ;
		}
		
		return 0.0f ;
	}
	
	public Float getWeight(String term) {
		if(terms.containsKey(term)) {
			return terms.get(term) ;
		}
		
		return 0.0f ;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder() ;
		for(String term : terms.keySet()) {
			sb.append(term + "\n") ;
		}
		return sb.toString() ;
	}
	
	public void dumpToFile(String fileName) {
		Path path = Paths.get(fileName) ;
		try {
			Files.write(path, terms.keySet(), ENCODING) ;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
