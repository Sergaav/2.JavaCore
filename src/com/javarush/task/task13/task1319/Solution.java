package com.javarush.task.task13.task1319;

/* 
Писатель в файл с консоли
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileWriter file = new FileWriter(reader.readLine());
        BufferedWriter writer = new BufferedWriter(file);

        String a="";
        while (!a.equals("exit")){

            a = reader.readLine();
            writer.write(a);
            writer.write("\n");

        }

        writer.close();
        reader.close();
    }
}
