package com.javarush.task.task13.task1318;

/* 
Чтение файла
*/


import java.io.*;


public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String path = reader.readLine();
        FileInputStream file = new FileInputStream(path);
        while (file.available()!=0){
            System.out.print((char) file.read());
        }



        reader.close();
       file.close();
    }
}