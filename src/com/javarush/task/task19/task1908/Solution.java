package com.javarush.task.task19.task1908;

/* 
Выделяем числа
*/

import java.io.*;
import java.util.LinkedList;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileNameIn = reader.readLine();
        String fileNameOut = reader.readLine();
        reader.close();
        FileReader fileReader = new FileReader(fileNameIn);
        BufferedReader reader1 = new BufferedReader(fileReader);
        LinkedList<Integer> list = new LinkedList<Integer>();
        String string = "";
        String stringOut = "";
        while ((string = reader1.readLine()) != null) {
            String[] mas = string.split(" ");
            for (int i = 0; i < mas.length; i++) {
                try {
                    stringOut += Integer.parseInt(mas[i])+" ";
                } catch (NumberFormatException e) {

                }

            }
        }
       reader1.close();
        System.out.println(stringOut);
        FileWriter fileWriter = new FileWriter(fileNameOut);
      BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(stringOut);
        bufferedWriter.close();

    }
}
