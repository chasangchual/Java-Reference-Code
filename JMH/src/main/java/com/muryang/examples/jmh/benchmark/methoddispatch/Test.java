package com.muryang.examples.jmh.benchmark.methoddispatch;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.Param;
import org.openjdk.jmh.annotations.Setup;

import java.util.Random;

/**
 * Created by chae on 3/26/2015.
 */
public class Test {
    @Param("100")
    private int count;

    private Data[] datas;

    @Setup
    public void setup() {
        datas = new Data[count];

        Random r = new Random();
        for (int c = 0; c < count; c++) {
            byte[] contents = new byte[10];
            r.nextBytes(contents);
            datas[c] = new Data(r.nextInt(2), contents);
        }
    }

    @Benchmark
    public void dynamic_Interface_Ref() {
        Data[] l = datas;
        int c = count;
        for (int i = 0; i < c; i++) {
            l[i].do_Dynamic_Interface_Ref();
        }
    }
}
