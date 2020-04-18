package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws IOException {
        if (args[0].equals("-u") || args[0].equals("-d")) {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String fileName = bufferedReader.readLine();
            Map<Integer, String> map = new LinkedHashMap<>();
            String string = "";
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader1 = new BufferedReader(fileReader);
            try {
                while (bufferedReader1.ready()) {
                    string = bufferedReader1.readLine();
                    map.put(Integer.parseInt(string.substring(0, 8).trim()), string.substring(8));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            switch (args[0]) {
                case ("-u"):
                    map.put(Integer.parseInt(args[1]), String.format("%-30.30s%-8s%-4s", args[2], args[3], args[4]));
                    break;
                case ("-d"):
                    map.remove(Integer.parseInt(args[1]));
                    break;
            }
            String stringOut = "";
            FileOutputStream fileOutputStream = new FileOutputStream(fileName);
            for (Map.Entry<Integer, String> pair : map.entrySet()) {
                stringOut = String.format("%-8s", pair.getKey().toString()) + pair.getValue() + "\n";
                fileOutputStream.write(stringOut.getBytes());
            }
            fileReader.close();
            fileOutputStream.close();

        }
    }
}
