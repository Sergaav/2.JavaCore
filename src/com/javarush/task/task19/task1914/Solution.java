package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {
        PrintStream consoleStream = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(outputStream);
        System.setOut(stream);
        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(consoleStream);
        String [] mas = result.split(" ");
        int a = Integer.parseInt(mas[0]);
        int b = Integer.parseInt(mas[2]);
        if (mas[1].equals("+")){
            System.out.println(a+" "+"+"+" "+b+" "+"="+" "+ (a+b));
        }
        if (mas[1].equals("-")){
            System.out.println(a+" "+"-"+" "+b+" "+"="+" "+ (a-b));
        }
        if (mas[1].equals("*")){
            System.out.println(a+" "+"*"+" "+b+" "+"="+" "+ (a*b));
        }


    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

