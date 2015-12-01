package com.muryang.examples.jmh.benchmark.methoddispatch;

/**
 * Created by chae on 3/26/2015.
 */
public class Coder1 implements Coder {
    public int work(byte[] data) {
        return data.length; // something light-weight
    }
}
