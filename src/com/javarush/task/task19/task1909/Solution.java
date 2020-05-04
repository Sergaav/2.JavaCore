package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileIn = reader.readLine();
        String fileOut = reader.readLine();
reader.close();
        FileReader fileReader = new FileReader(fileIn);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        LinkedList<Integer> list = new LinkedList<>();
        while (bufferedReader.ready()) {
            list.add(bufferedReader.read());
        }



        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 46) {
                list.set(i, 33);
            }
        }
        FileWriter fileWriter = new FileWriter(fileOut);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        for (int i = 0; i < list.size(); i++) {
            bufferedWriter.write(list.get(i));
        }
        bufferedReader.close();
        bufferedWriter.close();
    }
}
