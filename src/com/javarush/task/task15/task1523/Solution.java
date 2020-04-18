package com.javarush.task.task15.task1523;

/* 
Перегрузка конструкторов
*/

public class Solution {
    private String name;
    private int age;
    private int wegth;

     Solution (){

    }

    public Solution(String name, int age, int wegth) {
        this.name = name;
        this.age = age;
        this.wegth = wegth;
    }

    private Solution(String name, int age) {
        this.name = name;
        this.age = age;
    }

    protected Solution(String name) {
        this.name = name;
    }

    public static void main(String[] args) {


    }
}

