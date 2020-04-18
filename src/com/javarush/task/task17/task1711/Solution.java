package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {

        switch (args[0]) {
            case "-c":
                synchronized (allPeople){createPerson(args);}
                break;
            case "-u":
               synchronized (allPeople) {updatePerson(args);}
               break;
            case "-i":
                synchronized (allPeople) {readPerson(args);}
                break;
            case "-d":
               synchronized (allPeople) {deletePerson(args); }
               break;
        }


    }

    public static void createPerson(String[] args) throws ParseException {

        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        for (int i = 0; i < args.length-1; i += 3) {
            Person person;
            if (args[i + 2].equals("м")) {
                person = Person.createMale(args[i + 1], date.parse(args[i + 3]));
            } else
                person = Person.createFemale(args[i + 1], date.parse(args[i + 3]));

            allPeople.add(person);
            System.out.println(allPeople.size() - 1);
        }
    }

    public static void updatePerson(String[] args) throws ParseException {
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        for (int i = 0; i < args.length-1; i += 4) {
            Person person = allPeople.get(Integer.parseInt(args[i + 1]));
            person.setName(args[i + 2]);
            if (args[i + 3].equals("м")) {
                person.setSex(Sex.MALE);
            } else person.setSex(Sex.FEMALE);
            person.setBirthDate(date.parse(args[i + 4]));
        }
    }

    public static void deletePerson(String[] args) {
        for (int i = 0; i < args.length-1; i++) {
            Person person = allPeople.get(Integer.parseInt(args[i + 1]));
            person.setName(null);
            person.setSex(null);
            person.setBirthDate(null);
        }
    }


    public static void readPerson(String[] args) {
        SimpleDateFormat date1 = new SimpleDateFormat("dd-MMM-yyyy", Locale.ENGLISH);
        for (int i = 0; i < args.length-1; i++) {
            Person person = allPeople.get(Integer.parseInt(args[i + 1]));
            System.out.print(person.getName() + " ");
            if (person.getSex().equals(Sex.MALE)) {
                System.out.print("м" + " ");
            } else {
                System.out.print("ж" + " ");
            }
            System.out.print(date1.format(person.getBirthDate()));
            System.out.println();
        }
    }
}