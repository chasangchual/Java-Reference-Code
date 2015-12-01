package com.muryang.examples.gradle;

import org.joda.time.LocalTime;

/**
 * Created by chae on 3/19/2015.
 */
public class HelloWorld {
    public void main(String[] args) {
        LocalTime currentTime = new LocalTime();
        System.out.println("The current local time is:" + currentTime) ;

        Greeter greeter = new Greeter() ;
        System.out.println(greeter.sayHello()) ;
    }
}
