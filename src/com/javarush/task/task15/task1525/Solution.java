package com.javarush.task.task15.task1525;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Solution {
    public static List<String> lines = new ArrayList<String>();
    static {

        try {
          FileReader file = new FileReader(Statics.FILE_NAME);
            Scanner sc = new Scanner(file);
          while (sc.hasNext()) {
            lines.add(sc.nextLine());}
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        System.out.println(lines);
    }
}
