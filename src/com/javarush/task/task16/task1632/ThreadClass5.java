package com.javarush.task.task16.task1632;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreadClass5 implements Runnable {
    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int a=0;

        try {
            while (!(s=reader.readLine()).equals("N")) {
                a += Integer.parseInt(s);
            }
            System.out.println(a);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
