package com.javarush.task.task18.task1803;

/* 
Самые частые байты
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
        LinkedList<Integer> list = new LinkedList<>();
        while (fis.available() > 0) {
            list.add(fis.read());
        }
        fis.close();

        Map<Integer, Integer> map = new HashMap<>();
        int count = 0;
        for (int i = 0; i < list.size(); i++) {
            for (Integer integer : list) {
                if (list.get(i).equals(integer)) {
                    count++;
                }
            }
            if (!map.containsKey(list.get(i))) {
                map.put(list.get(i), count);
            }
            count = 0;
        }

        LinkedList<Integer> list1 = new LinkedList<>(map.values());
        Collections.sort(list1);
        Collections.reverse(list1);



for  (Map.Entry<Integer,Integer> pair : map.entrySet()){
    if (pair.getValue().equals(list1.get(0))){

    System.out.print(pair.getKey()+" ");
}

    }
}}
