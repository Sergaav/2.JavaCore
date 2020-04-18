package com.javarush.task.task16.task1632;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static List<Thread> threads = new ArrayList<>(5);
    static {
        threads.add(new Thread(new ThreadClass1()));
        threads.add(new Thread(new ThreadClass2()));
        threads.add(new Thread(new ThreadClass3()));
        threads.add(new ThreadClass4());
        threads.add(new Thread(new ThreadClass5()));

    }

    public static void main(String[] args) {

      //  for (Thread t : threads){
      //      t.start();
      //  }


    }


}