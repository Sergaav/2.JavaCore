package com.javarush.task.task19.task1906;

/* 
Четные символы
*/

import java.io.*;
import java.nio.CharBuffer;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        String file2 = reader.readLine();

        reader.close();
        LinkedList<Integer> list = new LinkedList<>();
        while (fileReader.ready()) {
            list.add(fileReader.read());
        }
        fileReader.close();
       StringBuilder sb = new StringBuilder();
        for (int i = 1; i < list.size(); i++) {
            if (i % 2 != 0) {
               sb.append(Character.toChars(list.get(i)));

               //
            }
        }
        System.out.println(sb.toString());
        FileWriter fileWriter = new FileWriter(file2);
        fileWriter.write(sb.toString());
        fileWriter.close();
    }
}
