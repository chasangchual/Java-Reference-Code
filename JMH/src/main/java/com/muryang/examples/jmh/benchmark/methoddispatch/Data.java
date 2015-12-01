package com.muryang.examples.jmh.benchmark.methoddispatch;

import org.openjdk.jmh.annotations.CompilerControl;

/**
 * Created by chae on 3/26/2015.
 */
public class Data {
    private static final Coder0 coder0 = new Coder0();
    private static final Coder1 coder1 = new Coder1();
    private final Coder coder;
    private final int id;
    private final byte[] data;

    public Data(int id, byte[] data) {
        this.id = id;
        this.data = data;
        this.coder = interface_ID_Switch();
    }

    private Coder interface_ID_Switch() {
        switch (id) {
            case 0: return coder0;
            case 1: return coder1;
            default:
                throw new IllegalStateException();
        }
    }

    @CompilerControl(CompilerControl.Mode.DONT_INLINE)
    public int do_Dynamic_Interface_Ref() {
        return coder.work(data);
    }}
