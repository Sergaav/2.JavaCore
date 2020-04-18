package com.javarush.task.task18.task1805;

/* 
Сортировка байт
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();
        FileInputStream fis = new FileInputStream(file);
        ArrayList<Integer> list = new ArrayList<>();
        while (fis.available() > 0) {
            list.add(fis.read());
        }
        fis.close();

        Collections.sort(list);

        Set<Integer> set = new HashSet<>(list);
for (Integer integer : set) {
    System.out.print(integer + " ");
}

    }
}
