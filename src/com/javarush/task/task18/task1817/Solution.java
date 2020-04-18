package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        FileInputStream fis =new FileInputStream(args[0]);
        byte [] mas = new byte [fis.available()];
        int count=0;
        while (fis.available() > 0) {
          count = fis.read(mas);
        }
        fis.close();
        int countSpace=0;
        for (int i=0;i< mas.length;i++){
            if (mas[i] == 32) {countSpace++;}
        }


            System.out.println(String.format("%(.2f",((double)countSpace/count)*100));

    }
}
