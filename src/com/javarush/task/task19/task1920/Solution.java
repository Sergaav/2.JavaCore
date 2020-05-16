package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        TreeMap <String,Double> map = new TreeMap<>();
        String string;
        while (bufferedReader.ready()){
            string=bufferedReader.readLine();
            String [] mas = string.split(" ");
            if (map.containsKey(mas[0])){
                double value =0;
                value+=map.get(mas[0])+Double.parseDouble(mas[1]);
                map.put(mas[0],value);
            }else map.put(mas[0],Double.parseDouble(mas[1]));
        }
        bufferedReader.close();
        LinkedList<Double> list = new LinkedList<>(map.values());
        Collections.sort(list);
        LinkedList<String> listName = new LinkedList<>();
        for (Map.Entry<String,Double> pair : map.entrySet()){
            if (pair.getValue().equals(list.get(list.size() - 1))){
                listName.add(pair.getKey());
            }
        }
        Collections.sort(listName);
        for (String s : listName){
        System.out.println(s);
    }}
}
