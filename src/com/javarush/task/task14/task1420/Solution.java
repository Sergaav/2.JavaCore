package com.javarush.task.task14.task1420;

/* 
НОД
*/

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int num1,num2;

        num1 = Integer.parseInt(bufferedReader.readLine()); // Integer.parseInt выбрасывает NumberFormatException если не может преобразовать строку к int
        if (num1 <= 0) throw new Exception(); // Отрицательные числа он может преобразовать, поэтому для выполнения условия задания проверяем число
        num2 = Integer.parseInt(bufferedReader.readLine());
        if (num2 <= 0) throw new Exception();

        ArrayList<Integer> numberOne = new ArrayList<>();
        ArrayList<Integer> numberTwo = new ArrayList<>();

        int max;

        for (int i = 1; i < num1 + 1; i++) {        //Все возможные делители чисел добавляются в массив
            if (num1 % i == 0) numberOne.add(i);
        }
        for (int i = 1; i < num2 + 1; i++) {
            if (num2 % i == 0) numberTwo.add(i);
        }

        if (numberOne.size() < numberTwo.size()){// Функция для выбора большего числа из 2 массивов требует, чтобы первый поданный массив был меньшим по длине
            max = maxFromTwo(numberOne,numberTwo); //Выбор наибольшего числа из 2 массивов
        }else max = maxFromTwo(numberTwo,numberOne);
        System.out.println(max);
    }
    public static int maxFromTwo (ArrayList<Integer> list1, ArrayList<Integer> list2){ // 1 is less than 2
        int max = 0;
        for (int i = 0; i < list1.size(); i++) {
            for (int j = i; j < list2.size(); j++) {
                if (list1.get(i).equals(list2.get(j))) max = list1.get(i);
            }
        }
        return max;
    }}