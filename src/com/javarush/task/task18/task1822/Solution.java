package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fis = new FileReader(reader.readLine());
        BufferedReader reader1 = new BufferedReader(fis);
        Map <Integer,String> map = new HashMap<>();
        while (reader1.ready()){
            String str = reader1.readLine();
            String [] mas = str.split(" ",2);
            map.put(Integer.parseInt(mas[0]),mas[1]);
        }
        for (Map.Entry<Integer,String> pair : map.entrySet()) {
            if (pair.getKey() == Integer.parseInt(args[0])) {
                System.out.println(pair.getKey()+" "+pair.getValue());
            }
        }
        reader1.close();
    }
}
