package com.surefor.ml.nlp;

import com.surefor.utils.FileUtils;
import opennlp.tools.tokenize.TokenizerME;
import opennlp.tools.tokenize.TokenizerModel;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by chae on 2/1/2016.
 */
public class Tokenizer {
    public static final String EN_TOKEN = "en-token.bin" ;
    private TokenizerModel model = null ;
    private opennlp.tools.tokenize.Tokenizer tokenizer = null ;

    public Tokenizer() {
        InputStream modelIn = null;
        try {
            modelIn = FileUtils.loadResourceAsStream(this.getClass().getClassLoader(), EN_TOKEN) ;
            model = new TokenizerModel(modelIn);
            tokenizer = new TokenizerME(model);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String[] tokenize(String sentense)
    {
        return tokenizer.tokenize(sentense) ;
    }
}
