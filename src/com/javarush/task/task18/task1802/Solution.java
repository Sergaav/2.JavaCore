package com.javarush.task.task18.task1802;

/* 
Минимальный байт
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
        ArrayList<Integer> list = new ArrayList<>();

        while (fis.available() > 0 ){
            list.add(fis.read());
        }
        fis.close();

        int b = Collections.min(list);
        System.out.println(b);
    }
}
