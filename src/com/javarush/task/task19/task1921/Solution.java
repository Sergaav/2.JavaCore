package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        FileReader fileReader = new FileReader(args[0]);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        ArrayList<String> list = new ArrayList<>();
         while (bufferedReader.ready()){
            list.add(bufferedReader.readLine());
        }
         bufferedReader.close();
          for (String line : list) {
            String[] person = line.split("(?<!\\d)\\s(?=\\d)", 2);
            PEOPLE.add(new Person(person[0], new SimpleDateFormat("dd MM yyyy").parse(person[1])));
        }
         for (Person p : PEOPLE) {
             System.out.println(p.getName()+" "+p.getBirthDate());
         }
    }
}
