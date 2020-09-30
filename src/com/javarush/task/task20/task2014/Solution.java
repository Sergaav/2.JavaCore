package com.javarush.task.task20.task2014;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

/* 
Serializable Solution
*/
public class Solution implements Serializable{
    public static void main(String[] args) throws IOException {
        System.out.println(new Solution(4));
        File file = new File("C:\\1\\1.txt");
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(file);

        Solution savedObject = new Solution(100);
        fos.write(savedObject.temperature);

        Solution loadedObject = new Solution(fis.read());


        System.out.println(savedObject);
        System.out.println(loadedObject);


    }

    private transient final String pattern = "dd MMMM yyyy, EEEE";
    private transient Date currentDate;
    private transient int temperature;
    String string;





    public Solution(int temperature) throws FileNotFoundException {
        this.currentDate = new Date();
        this.temperature = temperature;

        string = "Today is %s, and the current temperature is %s C";
        SimpleDateFormat format = new SimpleDateFormat(pattern);
        this.string = String.format(string, format.format(currentDate), temperature);
    }

    @Override
    public String toString() {
        return this.string;
    }
}
