package com.javarush.task.task18.task1819;

/* 
Объединение файлов
*/

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        FileInputStream fis1 = new FileInputStream(file1);
        FileInputStream fis2 = new FileInputStream(file2);
        int count1=fis1.available();
        int count2=fis2.available();
        byte[] mas = new byte[count1+count2];


        while (fis2.available() > 0) {
            fis2.read(mas,0, count2);
        }

        while (fis1.available() > 0) {
         fis1.read(mas, count2, count1);
        }
        fis1.close();

        fis2.close();

        FileOutputStream fos2 = new FileOutputStream(file1);

       fos2.write(mas);



       fos2.close();

    }
}
