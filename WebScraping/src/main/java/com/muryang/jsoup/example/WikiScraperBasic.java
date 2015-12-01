package com.muryang.jsoup.example;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by chae on 3/24/2015.
 */
public class WikiScraperBasic {
    public static void main(String[] aregs) {
        WikiScraperBasic.scrapeTopic("/wiki/Python");
    }


    public static void scrapeTopic(String url) {
        String html = getUrl("http://www.wikipedia.org/" + url) ;
        Document doc = Jsoup.parse(html) ;
        String conectsText = doc.select("#mw-content-text > p").first().text() ;
        System.out.println(conectsText) ;

    }

    public static String getUrl(String url) {
        URL urlObj = null ;

        try {
            urlObj = new URL(url) ;
        } catch(MalformedURLException e) {
            System.out.println("Malformed URL: " + url) ;
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

            in.close();
        } catch (IOException e) {
            System.out.println("There was an error connecting to the URL") ;
            return "" ;
        }

        return outputText ;
    }
}
