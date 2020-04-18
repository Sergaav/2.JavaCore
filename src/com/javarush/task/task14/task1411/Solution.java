package com.javarush.task.task14.task1411;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

/* 
User, Loser, Coder and Proger
*/

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        ArrayList<String> list = new ArrayList<>();
        Person person = null;
        String key = null;
        while (true) {
            key = reader.readLine();
            if (key.equals("user")) {
                list.add(key);
            }

            else if (key.equals("loser")) {
                list.add(key);
            }

            else if (key.equals("coder")) {
                list.add(key);
            }

            else if (key.equals("proger")) {
                list.add(key);
            }
            else break;
        }
        for (String s : list) {
            if (s.equals("user")) {
                person = new Person.User();
                doWork(person); //вызываем doWork
            }
            if (s.equals("loser")) {
                person = new Person.Loser();
                doWork(person); //вызываем doWork
            }
            if (s.equals("coder")) {
                person = new Person.Coder();
                doWork(person); //вызываем doWork
            }
            if (s.equals("proger")) {
                person = new Person.Proger();
                doWork(person); //вызываем doWork
            }
        }
    }

    public static void doWork(Person person) {
        if (person instanceof Person.User) {
            ((Person.User) person).live();
        }
        if (person instanceof Person.Loser) {
            ((Person.Loser) person).doNothing();
        }
        if (person instanceof Person.Coder) {
            ((Person.Coder) person).writeCode();
        }
        if (person instanceof Person.Proger) {
            ((Person.Proger) person).enjoy();
        }
    }
}
