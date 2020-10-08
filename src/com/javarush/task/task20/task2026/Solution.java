package com.javarush.task.task20.task2026;

/* 
Алгоритмы-прямоугольники
*/
public class Solution {
    public static void main(String[] args) {
        byte[][] a1 = new byte[][]{
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 0},
                {1, 1, 0, 1}
        };
        byte[][] a2 = new byte[][]{
                {1, 0, 0, 1},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {1, 0, 0, 1}
        };

        byte[][] a3 = new byte[][]{
                {1, 0, 0, 1, 1, 1},
                {0, 0, 0, 1, 1, 1},
                {0, 0, 0, 0, 0, 0},
                {1, 0, 0, 1, 1, 1}
        };

        int count1 = getRectangleCount(a1);
       System.out.println("count = " + count1 + ". Должно быть 2");
        int count2 = getRectangleCount(a2);
        System.out.println("count = " + count2 + ". Должно быть 4");
        int count3 = getRectangleCount(a3);
        System.out.println("count3 = "+count3);
    }

    public static int getRectangleCount(byte[][] a) {

        int count = 0;
        byte[][] temp = a.clone();

        for (int i = 0; i < temp.length; i++) {
            for (int j = 0; j < a[i].length; ) {
                if (a[i][j] == 1) {
                    count++;
                    deleteRectangle(temp, i, j);
                } else j++;
            }

        }
        return count;
    }

    public static void deleteRectangle(byte[][] temp, int x, int y) {
        for (int i = x; i < temp.length; ) {
            for (int j = y; j < temp[i].length; ) {
                if (temp[i][j] == 1) {
                    temp[i][j] = 0;
                    if (j < temp[i].length - 1 && temp[i][j + 1] == 1) {
                        j++;
                    } else j = temp[i].length;
                } else break;

            }
            if (i < temp.length - 1 && temp[i + 1][y] == 1) {
                i++;
            } else break;
        }

    }
}
