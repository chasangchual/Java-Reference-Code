package com.muryang.jsoup.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Random;

/**
 * Created by chae on 3/24/2015.
 */
public class WikiScraperInter {
    private static Random generator ;

    public static void main(String[] args) {
        generator = new Random(1024) ;
        scrapeTopic("/wiki/Java") ;
    }

    public static void scrapeTopic(String uri) {
        String html = getUrl("http://www.wikipedia.org/" + uri) ;
        Document doc = Jsoup.parse(html) ;
        Elements links = doc.select("#mw-content-text[href~=^/wiki/((?!:).)*$]") ;

        if(links.size() <= 0) {
            System.out.println("No links found at " + uri + ". Going back to Java !!") ;
            scrapeTopic("/wiki/Java") ;
        }

        int r = generator.nextInt(links.size()) ;
        System.out.println("Random link is : " + links.get(r).text() + "at url : " + links.get(r).attr("href")) ;

        scrapeTopic(links.get(r).attr("href")) ;
    }

    public static String getUrl(String url) {
        URL urlObj = null ;

        try {
            urlObj = new URL(url) ;
        } catch (MalformedURLException e) {
            e.printStackTrace();
            return "" ;
        }

        URLConnection urlConn = null ;
        BufferedReader in = null ;
        String outputText = "" ;

        try {
            urlConn = urlObj.openConnection() ;
            in = new BufferedReader(new InputStreamReader(urlConn.getInputStream())) ;
            String line = "" ;
            while((line = in.readLine()) != null) {
                outputText += line ;
            }
        } catch (IOException e) {
            e.printStackTrace();
            return "" ;
        }

        return outputText ;
    }
}