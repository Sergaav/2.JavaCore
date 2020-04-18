package com.javarush.task.task18.task1807;

/* 
Подсчет запятых
*/

import java.io.*;
import java.util.ArrayList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file = reader.readLine();

        FileInputStream fis = new FileInputStream(file);
  byte [] mas = new byte [fis.available()];
  if (fis.available() > 0){
      fis.read(mas);
  }
  fis.close();
  int count=0;
  for (int i=0;i<mas.length;i++){
      if (mas[i] == 44) count++;
  }
        System.out.println(count);
    }
}
