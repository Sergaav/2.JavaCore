package com.javarush.task.task16.task1601;

/* 
My first thread
*/

import org.w3c.dom.ls.LSOutput;

public class Solution {
    public static void main(String[] args) {
        TestThread task = new TestThread();
        new Thread(task).start();
    }

public static class TestThread implements Runnable{


    @Override
    public void run() {
        System.out.println( "My first thread");
    }
}}
