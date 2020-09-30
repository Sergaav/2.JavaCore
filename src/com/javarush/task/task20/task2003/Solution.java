package com.javarush.task.task20.task2003;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/* 
Знакомство с properties
*/
public class Solution {

    public static Map<String, String> runtimeStorage = new HashMap<>();


    public Solution() throws FileNotFoundException {
    }

    public static void save(OutputStream outputStream) throws Exception {
        Properties property = new Properties();
        for (Map.Entry<String,String> pair : runtimeStorage.entrySet()){
            property.setProperty(pair.getKey(),pair.getValue());
        }
        property.store(outputStream,"YooHoo");



    }

    public static void load(InputStream inputStream) throws IOException {
        Properties property = new Properties();
        property.load(inputStream);
        for (Object key : property.keySet()){
            runtimeStorage.put(key.toString(),property.getProperty(key.toString()));
        }

    }

    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             FileInputStream fos = new FileInputStream(reader.readLine())) {
            load(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println(runtimeStorage);
    }
}
