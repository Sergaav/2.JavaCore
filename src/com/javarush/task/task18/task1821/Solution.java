package com.javarush.task.task18.task1821;

/* 
Встречаемость символов
*/

import java.io.*;
import java.util.*;


public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream reader = new FileInputStream(args[0]);
        LinkedList<Integer> list = new LinkedList<>();
        LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
        try {
            while (reader.available() > 0) {
                list.add(reader.read());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(list);
        if (list.size() > 0) {
            int count = 1;
            for (int i = 0; i < list.size() - 1; i++) {
                if (list.get(i).equals(list.get(i + 1))) {
                    count++;
                } else {
                    map.put(list.get(i), count);
                    count = 1;
                }
            }
            map.put(list.get(list.size() - 1), count);
        }

        for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
            System.out.println((char) (pair.getKey().byteValue()) + " " + pair.getValue());
        }
        reader.close();

    }
}
