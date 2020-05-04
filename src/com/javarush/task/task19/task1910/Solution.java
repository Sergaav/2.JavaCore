package com.javarush.task.task19.task1910;

/* 
Пунктуация
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileIn = reader.readLine();
        String fileOut = reader.readLine();
        reader.close();
        FileReader fileReader = new FileReader(fileIn);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder string= new StringBuilder();
        while (bufferedReader.ready()){
            string.append((char)bufferedReader.read());
        }
        bufferedReader.close();
        String str = string.toString();
        Pattern pat = Pattern.compile("\\p{Punct}");
        Matcher matcher = pat.matcher(str);
        str = matcher.replaceAll("");
        FileWriter fileWriter = new FileWriter(fileOut);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        bufferedWriter.write(str);
        bufferedWriter.close();

    }
}
