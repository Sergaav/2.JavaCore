package com.javarush.task.task19.task1916;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/* 
Отслеживаем изменения
*/

public class Solution {
    public static List<LineItem> lines = new ArrayList<LineItem>();

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String file1 = reader.readLine();
        String file2 = reader.readLine();
        reader.close();
        FileReader fileReader1 = new FileReader(file1);
        BufferedReader bufferedReader1 = new BufferedReader(fileReader1);
        LinkedList<String> list1 = new LinkedList<>();
        while (bufferedReader1.ready()) {
            list1.add(bufferedReader1.readLine());
        }
        bufferedReader1.close();

        FileReader fileReader2 = new FileReader(file2);
        BufferedReader bufferedReader2 = new BufferedReader(fileReader2);
        LinkedList<String> list2 = new LinkedList<>();
        while (bufferedReader2.ready()) {
            list2.add(bufferedReader2.readLine());
        }
        bufferedReader2.close();

        for (int i = 0; i < list1.size() && i < list2.size(); i++) {
            if (list1.get(i).equals(list2.get(i))) {
                lines.add(new LineItem(Type.SAME, list1.get(i)));
            } else {
                try {
                    if (list1.get(i + 1).equals(list2.get(i))) {
                        lines.add(new LineItem(Type.REMOVED, list1.get(i)));
                        list2.add(i, null);
                    } else if (list1.get(i).equals(list2.get(i + 1))) {
                        lines.add(new LineItem(Type.ADDED, list2.get(i)));
                        list1.add(i, null);
                    }
                } catch (Exception e) {
                    try {
                        if (list1.get(i).equals(list2.get(i + 1))) {
                            lines.add(new LineItem(Type.ADDED, list2.get(i)));
                            list1.add(i, null);
                        }

                    } catch (Exception ex) {

                    }
                }

            }
        }
        if (list1.size() > list2.size() && list1.size() != list2.size()) {
            lines.add(new LineItem(Type.REMOVED, list1.get(list1.size() - 1)));
        } else if (list1.size() < list2.size() && list1.size() != list2.size()) {
            lines.add(new LineItem(Type.ADDED, list2.get(list2.size() - 1)));
        }


        for (LineItem lineItem : lines) {
            System.out.println(lineItem.type + " " + lineItem.line);
        }
    }


    public static enum Type {
        ADDED,        //добавлена новая строка
        REMOVED,      //удалена строка
        SAME          //без изменений
    }

    public static class LineItem {
        public Type type;
        public String line;

        public LineItem(Type type, String line) {
            this.type = type;
            this.line = line;
        }
    }
}