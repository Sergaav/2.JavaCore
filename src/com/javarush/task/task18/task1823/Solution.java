package com.javarush.task.task18.task1823;

import java.io.*;
import java.util.*;

/* 
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
        String str="";
        while (!(str = reader.readLine()).equals("exit")){
          ReadThread readThread = new ReadThread(str);
          readThread.start();
        }


        for (Map.Entry<String,Integer> pair : resultMap.entrySet()){
            System.out.println(pair.getKey()+" "+pair.getValue());
        }

    }

    public static class ReadThread extends Thread {
        public String fileName;

        public ReadThread(String fileName) {
            this.fileName = fileName;

        }

        @Override
        public void run() {
            try {
                FileInputStream fis = new FileInputStream(fileName);
                if (fis.available() > 0){
                LinkedList<Integer> list = new LinkedList<>();
                LinkedHashMap<Integer, Integer> map = new LinkedHashMap<>();
                while (fis.available() > 0) {
                    list.add(fis.read());
                }
                fis.close();
                Collections.sort(list);
                int count = 1;
                for (int i = 0; i < list.size() - 1; i++) {
                    if (list.get(i).equals(list.get(i + 1))) {
                        count++;
                    } else {
                        map.put(count, list.get(i));
                        count = 1;
                    }
                }
                map.put(count, list.get(list.size() - 1));
                LinkedList<Integer> list1 = new LinkedList<>();
                list1.addAll(map.keySet());
                Collections.sort(list1);
                for (Map.Entry<Integer, Integer> pair : map.entrySet()) {
                    if (pair.getKey().equals(list1.get(list1.size() - 1))) {
                        resultMap.put(fileName, pair.getValue());
                    }
                }}
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        // implement file reading here - реализуйте чтение из файла тут
    }
}
