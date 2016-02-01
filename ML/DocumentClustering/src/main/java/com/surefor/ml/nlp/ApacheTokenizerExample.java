package com.surefor.ml.nlp;

import com.surefor.utils.FileUtils;
import com.surefor.utils.SpringBeanHelper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

/**
 * Created by chae on 1/22/2016.
 */
public class ApacheTokenizerExample {
    public static void main(String[] args) throws IOException {
        SpringBeanHelper helper = SpringBeanHelper.getInstance() ;
        Tokenizer tokenizer = helper.getBean("tokenizer") ;
        BufferedReader br = null ;

        try {
            br = new BufferedReader(new InputStreamReader(FileUtils.loadResourceAsStream(ApacheTokenizerExample.class.getClassLoader(), "ErrorMessages.txt")));
            String str;
            while ((str = br.readLine()) != null) {
                String[] tokens = tokenizer.tokenize(str) ;
                System.out.println(Arrays.toString(tokens)) ;
            }
            String[] tokens = tokenizer.tokenize(str) ;
            System.out.println(Arrays.toString(tokens)) ;
        }
        catch (IOException e) {
        } finally {
            if(br != null) {
                br.close() ;
            }
        }

    }
}
