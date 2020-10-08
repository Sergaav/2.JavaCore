package com.javarush.task.task20.task2022;

import java.io.*;

/* 
Переопределение сериализации в потоке
*/
public class Solution implements Serializable, AutoCloseable {

    private transient FileOutputStream stream;
    private String fileName;

    public Solution (){

    }

    public Solution(String fileName) throws FileNotFoundException {
        this.stream = new FileOutputStream(fileName);
        this.fileName = fileName;
    }

    public void writeObject(String string) throws IOException {
        stream.write(string.getBytes());
        stream.write("\n".getBytes());
        stream.flush();
    }

    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();

    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        this.stream = new FileOutputStream(fileName, true);



    }

    @Override
    public void close() throws Exception {
        System.out.println("Closing everything!");
        stream.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String file="c:\\1\\1.dat";
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        Solution solution = new Solution("C:\\1\\1.txt");
        solution.writeObject("This is data for example!!!");
        out.writeObject(solution);

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        Solution solution1 = (Solution) in.readObject();


        System.out.println(solution1.fileName+" "+solution.fileName+" "+solution1.stream+" "+solution.stream);


    }
}
