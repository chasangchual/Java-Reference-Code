package com.surefor.utils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by chae on 1/22/2016.
 */
public class FileUtils {
    public static InputStream loadResourceAsStream(ClassLoader cl, String fileName) throws IOException {
        URL url = cl.getResource(fileName) ;

        if(url == null) {
            url = cl.getResource("/" + fileName) ;
        }

        if(url == null) {
            url = ClassLoader.getSystemClassLoader().getResource(fileName) ;
        }
        if(url == null) {
            url = ClassLoader.getSystemClassLoader().getResource("/" + fileName) ;
        }

        if(url != null) {
            return url.openStream() ;
        }

        return null ;
    }
}
