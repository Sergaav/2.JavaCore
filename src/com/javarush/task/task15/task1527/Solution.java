package com.javarush.task.task15.task1527;

/* 
Парсер реквестов
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String url = reader.readLine();
     if (url.contains("?")) {
        String temp = url.substring(url.indexOf("?")+1);
        LinkedHashMap<String,String> map = new LinkedHashMap<>();
        String [] temp1 = temp.split("&");
        for (String s : temp1) {
            if (s.contains("=")) {
                String[] temp3 = s.split("=");
                map.put(temp3[0], temp3[1]);
            } else map.put(s, null);
        }
        for (Map.Entry<String,String> pair : map.entrySet()){
            System.out.print(pair.getKey()+" ");

        }
        System.out.print("\b");
        for (Map.Entry<String,String> pair : map.entrySet()){
            if (pair.getKey().equals("obj")) {
                try {
                    System.out.println();
                    alert(Double.parseDouble(pair.getValue()));
                } catch (NumberFormatException e) {
                    alert(pair.getValue());
                }
            }
            }//else if (pair.getKey().equals("obj") && !pair.getValue().contains(".")) {
              //  System.out.println();
              //  alert(pair.getValue());
           // }
        }

    }

    public static void alert(double value) {
        System.out.println("double: " + value);
    }

    public static void alert(String value) {
        System.out.println("String: " + value);
    }
}
