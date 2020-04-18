package com.javarush.task.task18.task1818;

/* 
Два в одном
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();

        FileInputStream fis1 = new FileInputStream(file2);
        FileInputStream fis2 = new FileInputStream(file3);
        FileOutputStream fos = new FileOutputStream(file1, true);
        byte[] mas = new byte[fis1.available()];
        byte[] mas1 = new byte[fis2.available()];
        while (fis1.available() > 0) {
            fis1.read(mas);
        }
        while (fis2.available() > 0) {
            fis2.read(mas1);
        }
        fis1.close();
        fis2.close();
        fos.write(mas);
        fos.write(mas1);
        fos.close();
    }
}
