package com.javarush.task.task19.task1922;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Ищем нужные строки
*/

public class Solution {
    public static List<String> words = new ArrayList<String>();

    static {
        words.add("файл");
        words.add("вид");
        words.add("В");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        reader.close();
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = "";

        while (bufferedReader.ready()) {
            line = bufferedReader.readLine();
            String[] mas = line.split(" ");
            int count = 0;
            for (int i = 0; i < mas.length; i++) {
                for (int j = 0; j < words.size(); j++) {
                    if (mas[i].trim().equals(words.get(j))) {
                        count++;
                    }
                }
            }
            if (count==2){
                System.out.println(line);
            }
        }
        bufferedReader.close();

    }
}
