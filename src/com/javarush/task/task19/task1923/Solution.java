package com.javarush.task.task19.task1923;

/* 
Слова с цифрами
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class Solution {
    public static void main(String[] args) throws IOException {

        FileReader fileReader = new FileReader(args[0]);
        FileWriter fileWriter = new FileWriter(args[1]);


        StringBuilder sb = new StringBuilder();
        while (fileReader.ready()) {
            sb.append((char) fileReader.read());
        }
        fileReader.close();
        String str = sb.toString().replace("\n", " ");
        str = str.replace("\\p{Punkt}"," ");
        String[] mas = str.split(" ");
        StringBuilder string = new StringBuilder();

        for (int i = 0; i < mas.length; i++) {
            Pattern pattern = Pattern.compile("\\p{javaDigit}");
            Matcher matcher = pattern.matcher(mas[i]);

           // Pattern pattern1 = Pattern.compile("\\p{Punct}");
           // Matcher matcher1 = pattern1.matcher(mas[i]);
         //   mas[i] = matcher1.replaceAll("");

            if (matcher.find()) {
                string.append(mas[i]).append(" ");
            }

        }

        fileWriter.write(string.toString());
        fileWriter.close();
    }
}
