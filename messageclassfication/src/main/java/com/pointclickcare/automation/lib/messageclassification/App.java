package com.pointclickcare.automation.lib.messageclassification;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.pointclickcare.automation.lib.messageclassification.utils.TestFailureUtil;

/**
 * Hello world!
 *
 */
@Component
public class App 
{
	@Autowired
    TestFailureDTO dto ; 
    public static void main( String[] args )
    {	
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("ApplicationBeans.xml") ; 
    	App main = context.getBean(App.class) ;
    	main.run() ;
    	context.close() ;
    }
    
    public void run()    {
        List<TestFailure> failures = dto.loadFailures() ;
        DocumentCollection documents = DocumentCollection.getInstance() ;
        TermCollection terms = TermCollection.getInstance() ;
        
        TestFailureUtil.buildDocumentCollection(failures, documents) ;
        TestFailureUtil.buildTermCollection(failures, terms) ;
        
        for(int i = 0 ; i < terms.size() ; i++) {
        	String term = terms.get(i) ;
            Integer count = documents.findTermFrequency(term) ;
            // Calculate idf weight against a term
            Float weight = (float) Math.log((double) documents.size() / (double) count) ;
            terms.setWeithg(term, weight) ;
            //System.out.println(String.valueOf(i) + "." + term + " : " + String.valueOf(weight)) ;
        }
        
        for(int i = 0 ; i < documents.size(); i++) {
        	String document = documents.get(i) ;
        	String[] words = document.split("\\s+") ;
        	
        	System.out.println(document); 
        	
        	for(String word : words) {
        		TermItem item = new TermItem() ; 
        		float tfidf = VectorSpaceModel.findTFIDF(documents.get(i), word) ;
        		
        		item.setTerm(word) ;
        		item.setTfidf(tfidf) ;
        		
        		Integer pos = -1 ; 
        		while((pos = document.indexOf(word, pos+1)) >= 0) {
        			item.addPos(pos) ;
        		}
        		
        		if(tfidf > 0.0)
        			System.out.println(item.toString()) ;
        	}
        }
    }
}
