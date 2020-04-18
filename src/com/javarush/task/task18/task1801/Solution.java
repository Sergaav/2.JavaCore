package com.javarush.task.task18.task1801;

/* 
Максимальный байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();

        FileInputStream fis = new FileInputStream(file);
        ArrayList<Integer> list = new ArrayList<Integer>();
        int a;
        while ((a = fis.read()) != -1) {
            list.add(a);
        }
        fis.close();

        int b = Collections.max(list);

        System.out.println(b);

           }
}