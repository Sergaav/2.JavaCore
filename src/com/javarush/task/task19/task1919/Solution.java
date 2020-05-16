package com.javarush.task.task19.task1919;

/* 
Считаем зарплаты
*/

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collections;

import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        TreeMap<String, Double> map = new TreeMap<>();
        String string = "";
        while (bufferedReader.ready()) {
            string = bufferedReader.readLine();
            String[] mas = string.split(" ");
            if (map.containsKey(mas[0])) {
                double value = Double.parseDouble(mas[1]);
                value += map.get(mas[0]);
                map.put(mas[0], value);
            }else map.put(mas[0],Double.parseDouble(mas[1]));
        }
        bufferedReader.close();
        for (Map.Entry<String,Double> pair : map.entrySet()){
            System.out.println(pair.getKey()+" "+pair.getValue());
        }

    }
}
