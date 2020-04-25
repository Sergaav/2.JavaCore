package com.javarush.task.task19.task1904;

/* 
И еще один адаптер
*/

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner{
        private Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner) {
            this.fileScanner = fileScanner;
        }



        @Override
        public Person read() throws IOException, ParseException {
            String s="";
            if (fileScanner.hasNext()){
               s = fileScanner.nextLine();
            }
            String [] mas = s.split(" ");
            String date = mas[3]+mas[4]+mas[5];
            SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy", Locale.ENGLISH);
            Date birthDate = dateFormat.parse(date);
            return new Person(mas[1],mas[2],mas[0],birthDate);


        }

        @Override
        public void close() throws IOException {
           fileScanner.close();
        }
    }
}
