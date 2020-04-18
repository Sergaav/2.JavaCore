package com.javarush.task.task18.task1827;

/* 
Прайсы
*/

import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws Exception {

        try {
            if (args[0].equals("-c")) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
                String fileName = reader.readLine();
                FileReader fis = new FileReader(fileName);
                BufferedReader reader1 = new BufferedReader(fis);
                LinkedList<Integer> listId = new LinkedList<Integer>();
                String string;
                while (reader1.ready()) {
                    string = reader1.readLine();
                    listId.add(Integer.parseInt(string.substring(0, 8).trim()));
                }
                reader1.close();
                Collections.sort(listId);


                    String outLine = String.format("\n%-8s%-30.30s%-8s%-4s", (listId.get(listId.size() - 1)) + 1, args[1], args[2], args[3]);
                    System.out.println(outLine);
                    FileOutputStream fos = new FileOutputStream(fileName, true);
                    fos.write(outLine.getBytes());
                    fos.close();
                }
        } catch (Exception e) {
            System.out.println("Нет аргументов");
        }
    }

    }

