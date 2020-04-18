package com.javarush.task.task15.task1531;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

/* 
Факториал
*/

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(reader.readLine());
        reader.close();

        System.out.println(factorial(input));
    }

    public static String factorial(int n) {
        BigInteger f = new BigInteger("1");
        String factor=null;
        if (n <= 150 && n > 0) {
            for (int i = 1; i < n; i++) {
                f = f.multiply((BigInteger.valueOf(i + 1)));
            }
            factor=String.valueOf(f);
        } else if (n == 0) {factor = "1";}
        else if (n < 0) {factor = "0";}
        return factor;
    }
}
