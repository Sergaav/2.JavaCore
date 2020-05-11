package com.javarush.task.task19.task1925;

/* 
Длинные слова
*/

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {

           FileReader fileReader = new FileReader(args[0]);
           FileWriter fileWriter = new FileWriter(args[1]);
       BufferedReader bufferedReader = new BufferedReader(fileReader);
        StringBuilder stringBuilder = new StringBuilder();
        while (bufferedReader.ready()){
           stringBuilder.append(Character.valueOf((char) bufferedReader.read()));
       }
        bufferedReader.close();
        String str = stringBuilder.toString();
        //Pattern pattern = Pattern.compile("\\p{Punct}");
       // Matcher matcher = pattern.matcher(str);
       // str = matcher.replaceAll(" ");
        Pattern pattern1 = Pattern.compile("\\n");
        Matcher matcher1 = pattern1.matcher(str);
        str = matcher1.replaceAll(" ");

        String [] strings = str.split(" ");
        for (int i=0;i<strings.length;i++){
            strings[i]=strings[i].trim();
        }
        StringBuilder stringBuilder1 = new StringBuilder();
        for (int i=0;i < strings.length;i++) {
            if (strings[i].length() > 6) {
                stringBuilder1.append(strings[i]).append(",");
            }}
        String string1 = stringBuilder1.deleteCharAt(stringBuilder1.lastIndexOf(",")).toString();

        fileWriter.write(string1);
        fileWriter.close();

    }
}
