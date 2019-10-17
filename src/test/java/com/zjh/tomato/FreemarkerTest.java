package com.zjh.tomato;

import java.util.Date;

public class FreemarkerTest {
    public static void main(String[] args) {
        Long t1 = System.currentTimeMillis();
        System.out.println("System.currentTimeMillis() = " + System.currentTimeMillis());
        Date date = new Date(System.currentTimeMillis());
        System.out.println("date = " + date);
        Long t2 = System.currentTimeMillis();

        System.out.println("(t1-t2) = " + (t1 - t2));
    }
}