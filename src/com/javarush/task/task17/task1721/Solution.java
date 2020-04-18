package com.javarush.task.task17.task1721;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/* 
Транзакционность
*/

public class Solution {
    public static List<String> allLines = new ArrayList<String>();
    public static List<String> forRemoveLines = new ArrayList<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader consolReader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = consolReader.readLine();
        String file2 = consolReader.readLine();

        File fileName1 = new File(file1);
        File fileName2 = new File(file2);
        BufferedReader reader= new BufferedReader(new FileReader(fileName1));
        BufferedReader reader1 = new BufferedReader(new FileReader(fileName2));
        String s= "";

        while ((s=reader.readLine()) !=null){
            allLines.add(s);
        }
        while ((s=reader1.readLine()) != null){
            forRemoveLines.add(s);
        }
        reader.close();
        reader1.close();
        Solution solution = new Solution();
        try {
            solution.joinData();
        } catch (CorruptedDataException e) {
            e.printStackTrace();
        }

    }

    public void joinData() throws CorruptedDataException {

        if (allLines.containsAll(forRemoveLines)) {
            allLines.removeAll(forRemoveLines);

        }else {allLines.clear();

        throw new CorruptedDataException();}

    }
}
