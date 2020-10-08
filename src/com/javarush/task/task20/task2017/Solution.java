package com.javarush.task.task20.task2017;

import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;

/* 
Десериализация
*/
public class Solution {
    public A getOriginalObject(ObjectInputStream objectStream) throws IOException, ClassNotFoundException {
        A a;
        try {
        a = (A) objectStream.readObject();

           return a;
        } catch (Exception e) {
            System.out.println("NOOOO");
            return a=null;
        }


    }

    public class A implements Serializable {
    }

    public class B extends A {
        public B() {
            System.out.println("inside B");
        }
    }

    public static void main(String[] args) {

    }
}
