package com.javarush.task.task17.task1710;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();


    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws IOException, ParseException {

        switch (args[0]) {
            case "-c":
                createPerson(args);
                break;
            case "-u":
                updatePerson(args);
                break;
            case "-i":
                readPerson(args);
                break;
            case "-d":
                deletePerson(args);
                break;
        }




       }



    public static void createPerson(String [] args) throws ParseException {
        Person person;
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        if (args[2].equals("м")){
           person = Person.createMale(args[1], date.parse(args[3]));
        }else
             person = Person.createFemale(args[1],date.parse(args[3]));

        allPeople.add(person);
        System.out.println(allPeople.size()-1);
    }
    public static void updatePerson(String [] args) throws ParseException {
        SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        Person person=allPeople.get(Integer.parseInt(args[1]));
        person.setName(args[2]);
        if (args[3].equals("м")) {person.setSex(Sex.MALE);}
        else {person.setSex(Sex.FEMALE);}
        person.setBirthDate(date.parse(args[4]));
       // allPeople.set(Integer.parseInt(args[1]),person);

    }
    public static void deletePerson(String [] args){
      Person person = allPeople.get(Integer.parseInt(args[1]));
      person.setName(null);
      person.setSex(null);
      person.setBirthDate(null);

}
    public static void readPerson(String [] args){
    SimpleDateFormat date1 = new SimpleDateFormat("dd-MMM-yyyy",Locale.ENGLISH);
    Person person = allPeople.get(Integer.parseInt(args[1]));
        System.out.print(person.getName()+" ");
        if (person.getSex().equals(Sex.MALE)) System.out.print("м"+" ");
        else System.out.print("ж" +" ");
        System.out.print(date1.format(person.getBirthDate()));


    }
}
