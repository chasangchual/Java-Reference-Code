package com.pointclickcare.automation.lib.messageclassification;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class DocumentCollection {
	static private DocumentCollection instance = null ; 
	private List<String> documentList = new ArrayList<String>() ;
	final static Charset ENCODING = StandardCharsets.UTF_8;
	
	synchronized public static DocumentCollection getInstance() {
		if(instance == null) {
			instance = new DocumentCollection() ;
		}
		
		return instance ;
	}
	
	private DocumentCollection() {
		
	}
	
	public void clear() {
		documentList.clear() ;
	}
	
	public int size() {
		return documentList.size() ;
	}
	
	public void add(String document)	{
		if(document != null && document.trim().length() > 0) {
			documentList.add(document.trim()) ;
		}
	}
	
	public String get(int i) {
		if(i >= 0 && i < documentList.size()) {
			return documentList.get(i) ;
		}
		
		return null ;
	}
	
	public int findTermFrequency(String term)
	{
		int count = 0 ; 
		
		for(String document : documentList) {
			if(document.toUpperCase().contains(term.toUpperCase())) {
				count ++ ;
			}
		}
		
		return count ;
	}
	
	public void dumpToFile(String fileName) {
		Path path = Paths.get(fileName) ;
		try {
			Files.write(path, documentList, ENCODING) ;
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
