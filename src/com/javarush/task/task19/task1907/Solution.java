package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName = reader.readLine();
        FileReader fileReader = new FileReader(fileName);
        reader.close();
        StringBuilder string = new StringBuilder();
        while (fileReader.ready()) {
            string.append(Character.toChars(fileReader.read()));
        }
        fileReader.close();
        Pattern pat = Pattern.compile("\\W");
        //Matcher matcher;
        String[] mas = pat.split(string.toString());
        int count = 0;
        for (int i = 0; i < mas.length; i++) {
            if (mas[i].equals("world")) {
                count++;
            }

        }
        System.out.println(count);
    }
}
