package com.javarush.task.task18.task1808;

/* 
Разделение файла
*/

import java.io.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        String file3 = reader.readLine();

        FileInputStream fis = new FileInputStream(file1);
        byte[] mas = new byte [fis.available()];
        int count = 0;
        try {
            if (fis.available() > 0) {
                count = fis.read(mas);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        fis.close();

        FileOutputStream fos1 = new FileOutputStream(file2);
        FileOutputStream fos2 = new FileOutputStream(file3);

    if (count > 1){
        if ((count % 2) == 0) {
            fos1.write(mas, 0, count / 2);
            fos2.write(mas, count/2, count / 2 );


        } else {
            fos1.write(mas, 0, (count / 2)+1);

            fos2.write(mas, (count/2)+1, count/2);
        }} else fos1.write(mas);


        fos1.close();
        fos2.close();

    }
}
