package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Solution {
    public static void main(String[] args) throws IOException {

        FileInputStream fis = new FileInputStream(args[0]);
        byte[] mas = new byte[fis.available()];
        int count = 0;
        while (fis.available() > 0) {
            count = fis.read(mas);
        }
        fis.close();
        int countAlphabet = 0;
        for (int i = 0; i < mas.length; i++) {
            if ((mas[i] >= 65 && mas[i] <= 90) || (mas[i] >= 97 && mas[i] <= 122)) {
                countAlphabet++;
            }
        }
        System.out.println(countAlphabet);

    }
}
