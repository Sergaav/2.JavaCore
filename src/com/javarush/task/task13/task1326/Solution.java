package com.javarush.task.task13.task1326;

/* 
Сортировка четных чисел из файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws IOException {
        ArrayList<Integer> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        FileInputStream stream = new FileInputStream(file);
        BufferedReader reader1 = new BufferedReader(new InputStreamReader(stream));
        String s;
        while (reader1.ready()) {
            s=reader1.readLine();
            if (Integer.parseInt(s) % 2 == 0) {
                list.add(Integer.parseInt(s));
           }

        }
        Collections.sort(list);
        for (int i : list){
        System.out.println(i);}
        reader.close();
        reader1.close();
        stream.close();
    }
}
