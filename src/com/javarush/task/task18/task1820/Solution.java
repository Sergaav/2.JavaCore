package com.javarush.task.task18.task1820;

/* 
Округление чисел
*/

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
       BufferedReader reader1 = new BufferedReader(new FileReader(file1));
       FileOutputStream fos = new FileOutputStream(file2);

       StringBuilder sb = new StringBuilder(reader1.readLine());
      String string = sb.toString();
      String [] strings = string.split(" ");
     long [] string1 = new long [strings.length];
      for (int i=0;i< strings.length;i++){
        string1[i] = Math.round(Double.parseDouble(strings[i]));
         }
        StringBuilder str= new StringBuilder();
        for (int i=0;i< strings.length;i++){
            str.append(string1[i]).append(" ");
      }
       fos.write(str.toString().getBytes());
        reader1.close();
        fos.close();
    }
}
