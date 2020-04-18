package com.javarush.task.task15.task1519;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/* 
Разные методы для разных типов
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String value = null;
        while (true) {
            value = reader.readLine();
            if (value.equals("exit")) {
                break;
            }

            try {
                Double.parseDouble(value);

            } catch (NumberFormatException e) {
                print(value);
                continue;
            }

            // try {
            //     Long.parseLong(value);
            //      if (Long.parseLong(value) > Integer.MAX_VALUE || Long.parseLong(value)< Integer.MIN_VALUE) print(value);
            //  } catch (NumberFormatException e) {
            //     print(value);
            //  }
            if (value.contains(".")) {
                try {
                    print(Double.parseDouble(value));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            } else if (Long.parseLong(value) > 0 && Long.parseLong(value) < 128) {
                try {
                    print(Short.parseShort(value));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }
            } else if (Long.parseLong(value) >= Integer.MAX_VALUE || Long.parseLong(value) <= Integer.MIN_VALUE) {
                print(value);
            } else if (Long.parseLong(value) <= 0 || Long.parseLong(value) >= 128) {
                try {
                    print(Integer.parseInt(value));
                } catch (NumberFormatException e) {
                    e.printStackTrace();
                }

            }
            // else if (Long.parseLong(value) > Integer.MAX_VALUE || Long.parseLong(value)<Integer.MIN_VALUE){
            //     print(value);
            //   }


        }
    }


    public static void print(Double value) {
        System.out.println("Это тип Double, значение " + value);
    }

    public static void print(String value) {
        System.out.println("Это тип String, значение " + value);
    }

    public static void print(short value) {
        System.out.println("Это тип short, значение " + value);
    }

    public static void print(Integer value) {
        System.out.println("Это тип Integer, значение " + value);
    }
}
