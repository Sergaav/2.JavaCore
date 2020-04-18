package com.javarush.task.task18.task1809;

/* 
Реверс файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        String file1 = reader.readLine();
        String file2 = reader.readLine();

        FileInputStream fis = new FileInputStream(file1);
        FileOutputStream fos = new FileOutputStream(file2);

        byte[] mas = new byte[fis.available()];
        int count = 0;
        if (fis.available() > 0) {
            count = fis.read(mas);
        }
        fis.close();
        byte[] mas1 = new byte[mas.length];
        int j = 0;
        for (int i = mas.length - 1; i >= 0; i--) {
            mas1[j] = mas[i];
            j++;
        }
        fos.write(mas1);
        fos.close();


    }
}
