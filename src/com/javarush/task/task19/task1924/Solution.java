package com.javarush.task.task19.task1924;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

/* 
Замена чисел
*/

public class Solution {
    public static Map<Integer, String> map = new HashMap<Integer, String>();

    static {
        map.put(0, "ноль");
        map.put(1, "один");
        map.put(2, "два");
        map.put(3, "три");
        map.put(4, "четыре");
        map.put(5, "пять");
        map.put(6, "шесть");
        map.put(7, "семь");
        map.put(8, "восемь");
        map.put(9, "девять");
        map.put(10, "десять");
        map.put(11, "одиннадцать");
        map.put(12, "двенадцать");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(bufferedReader.readLine());
        bufferedReader.close();
        BufferedReader bufferedReader1 = new BufferedReader(fileReader);
        while (bufferedReader1.ready()) {
            String string = bufferedReader1.readLine();
            String[] strings = string.split(" ");
            for (int i = 0; i < strings.length; i++) {
                try {
                    int k = Integer.parseInt(strings[i].trim());
                    if (k >= 0 && k <= 12) {
                        strings[i] = strings[i].replaceFirst(String.valueOf(k), map.get(k));
                    }
                } catch (NumberFormatException e) {
                    continue;
                }
            }

            StringBuilder outString = new StringBuilder();
            for (int i = 0; i < strings.length; i++) {
                outString.append(strings[i]).append(" ");
            }
            outString.deleteCharAt(outString.lastIndexOf(" "));
            System.out.println(outString.toString());
        }
        bufferedReader1.close();

    }
}
