package com.pointclickcare.automation.lib.messageclassification;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.SortedMap;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class WordManager {
	private SortedMap<String, String> words = new TreeMap<String, String>() ; 
	private static WordManager instance = null ;
	final static Charset ENCODING = StandardCharsets.UTF_8;
	
	public synchronized static WordManager getInstance() {
		if(instance == null) {
			instance = new WordManager() ;
		}
		return instance ;
	}
	
	private WordManager() {
		
	}
	
	public void clear() {
		words.clear() ;
	}
	
	public Integer size() {
		return words.size() ;
	}
	
	public void add(String term) {
		add(term, "") ;
	}
	
	public void add(String term, String str) {
		if(!words.containsKey(term)) {
			words.put(term, str) ;
		}
	}
	
	public void splitAndAdd(String str)
	{
		StringTokenizer tokenizer = new StringTokenizer(str) ;
		if(str != null && str.trim().length() > 0) {
			String[] words = str.split("\\s+|/|::|//|[|](|)|,") ;
			for(String word : words) {
				add(word, str) ;
			}
		}
	}
	
	public String get(Integer index) {
		if(index >= 0 && index < words.size()) {
			return (String)(words.keySet().toArray())[index] ;
		} else {
			return null ;
		}
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder() ;
		for(String term : words.keySet()) {
			sb.append(term + "\n") ;
		}
		return sb.toString() ;
	}
	
	public void dumpToFile(String fileName) {
		Path path = Paths.get(fileName) ;
		try {
			Files.write(path, words.keySet(), ENCODING) ;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void dumpAllToFile(String fileName) {
		Path path = Paths.get(fileName) ;
	    try (BufferedWriter writer = Files.newBufferedWriter(path, ENCODING)){
			for(String term : words.keySet()) {
				writer.write(term + "\n") ;
			}
			
			for(String term : words.keySet()) {
				writer.write(term + " | " + words.get(term)) ;
		        writer.newLine();
			}
	    } catch(Exception e) {
	    }
	}
}
