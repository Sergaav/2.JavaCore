package com.javarush.task.task19.task1918;

/* 
Знакомство с тегами
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        FileReader fileReader = new FileReader(reader.readLine());
        reader.close();
        StringBuilder sb = new StringBuilder();
        while (fileReader.ready()) {
            sb.append((char) fileReader.read());
        }
        fileReader.close();
        String string = sb.toString().replaceAll("\n","").replaceAll("\r","");


        Pattern pattern = Pattern.compile("<(" + args[0] + ")[^>]*?>.*?(<\\1[^>]*?>.*?</\\1>).*?</\\1>");
        Matcher matcher = pattern.matcher(string);
        while (matcher.find()) {

            System.out.println(matcher.group(0));
            String temp = matcher.group(2);
            if (temp != null){
                System.out.println(temp);
            }
        }
        Pattern pattern1 = Pattern.compile("<(" + args[0] + ")>[^>]*?</\\1>");
        Matcher matcher1 = pattern1.matcher(string);
        while (matcher.find()) {
            System.out.println(matcher1);

        }



    }
}
