package com.javarush.task.task20.task2025;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/* 
Алгоритмы-числа
*/
public class Solution {


    private static long[][] myPow() {
        long[][] myPow = new long[10][19];
        for (int i = 0; i < 10; i++) {
            for (int j = 1; j < 19; j++) {
                myPow[i][j] = (long) Math.pow(i, j);
            }
        }
        return myPow;
    }


    public static long[] getNumbers(long N) {

        long[] result = null;



        return result;
    }


    public static void main(String[] args) {
        long a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000)));
        long b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);

        a = System.currentTimeMillis();
        System.out.println(Arrays.toString(getNumbers(1000000000)));
        b = System.currentTimeMillis();
        System.out.println("memory " + (Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory()) / (8 * 1024));
        System.out.println("time = " + (b - a) / 1000);


    }

    public static boolean isMinNumber(long N) {
        boolean isMinNumber = true;

        byte[] mas = masDigits(N, countDigits(N));
        for (int i = 0; i < mas.length - 1; i++) {
            if (mas[i] > mas[i + 1]) {
                isMinNumber = false;
                i = mas.length;
            }
        }return isMinNumber;
    }

        public static boolean isArmstrong (long N){
         for (long i = 1; i < N; i++) {
             if (isMinNumber(i)){
                 

             }

         }



    }


    public static List<Long> clonesNumber(long N) {

    }

    public static int countDigits(long N) {

        if (N < 100000) {
            if (N < 10000) {
                if (N < 1000) {
                    if (N < 100) {
                        if (N < 10) {
                            return 1;
                        } else return 2;
                    } else return 3;
                } else return 4;
            } else return 5;
        } else if (N < 100000000) {
            if (N < 10000000) {
                if (N < 1000000) {
                    return 6;
                } else return 7;
            } else return 8;
        } else if (N < 100000000000L) {
            if (N < 10000000000L) {
                if (N < 1000000000) {
                    return 9;
                } else return 10;
            } else return 11;
        } else if (N < Long.MAX_VALUE) {
            if (N < 1000000000000000000L) {
                if (N < 100000000000000000L) {
                    if (N < 10000000000000000L) {
                        if (N < 1000000000000000L) {
                            if (N < 100000000000000L) {
                                if (N < 10000000000000L) {
                                    if (N < 1000000000000L) {
                                        return 12;
                                    } else return 13;
                                } else return 14;
                            } else return 15;
                        } else return 16;
                    } else return 17;
                } else return 18;
            } else return 19;
        }
        return 0;
    }

    public static byte[] masDigits(long N, int digitsNumber) {
        byte[] mas = new byte[digitsNumber];
        for (int i = digitsNumber - 1; i >= 0; i--) {
            mas[i] = (byte) (N % 10);
            N = N / 10;
        }
        return mas;
    }


}
