package com.javarush.task.task18.task1825;

/* 
Собираем файл
*/

import java.io.*;
import java.util.Collections;
import java.util.LinkedList;

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String fileName="";
        LinkedList <String> list = new LinkedList<>();
        try {
            while (! (fileName=reader.readLine()).equals("end")) {
                list.add(fileName);
               }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.sort(list);
        String[] fileOut = list.get(0).split(".part",3);
        FileWriter fileWriter = new FileWriter(fileOut[0],true);
        BufferedWriter writer = new BufferedWriter(fileWriter);
        for (int i=0;i<list.size();i++){
            FileReader fis = new FileReader(list.get(i));
            BufferedReader reader1 = new BufferedReader(fis);
            while (reader1.ready()){
            writer.write(reader1.read());

        }reader1.close();
        }
        writer.close();

    }
}
