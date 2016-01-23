package com.surefor.ml.nlp;

import opennlp.tools.tokenize.Tokenizer;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;
import opennlp.tools.util.InvalidFormatException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;

/**
 * Created by chae on 1/22/2016.
 */
public class ApacheTokenizerExample {
    public static void main(String[] args) {
        ApacheTokenizerExample example = new ApacheTokenizerExample() ;

        example.run();
    }

    public void run() {
        try {
            System.out.println(this.getClass().getClassLoader().getResource("en-token.bin").toURI().toString()) ;
            InputStream modelIn = this.getClass().getClassLoader().getResourceAsStream("en-token.bin") ;
            TokenizerModel model = new TokenizerModel(modelIn);
            Tokenizer tokenizer = new TokenizerME(model);
            String tokens[] = tokenizer.tokenize("An input sample sentence.");
            System.out.println(tokens) ;
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidFormatException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
