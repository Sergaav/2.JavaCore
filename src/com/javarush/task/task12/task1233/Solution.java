package com.javarush.task.task12.task1233;

/* 
Изоморфы наступают
*/

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static void main(String[] args) throws Exception {
        int[] data = new int[]{1, 2, 3, 5, -2, -8, 0, 77, 5, 5};

        Pair<Integer, Integer> result = getMinimumAndIndex(data);

        System.out.println("The minimum is " + result.x);
        System.out.println("The index of the minimum element is " + result.y);
    }

    public static Pair<Integer, Integer> getMinimumAndIndex(int[] array) {
        if (array == null || array.length == 0) {
            return new Pair<Integer, Integer>(null, null);
        }
        HashMap <Integer,Integer> map = new HashMap<>();
        for (int i=0;i<array.length;i++){
            map.put(i,array[i]);
        }
        Integer x = Collections.min(map.values());
        Integer y=0;
        for (Map.Entry<Integer,Integer> pair : map.entrySet()){
            if (x.equals(pair.getValue())) {
                y = pair.getKey();
            }
        }

        return new Pair<Integer, Integer>(x, y );
    }


    public static class Pair<X, Y> {
        public X x;
        public Y y;

        public Pair(X x, Y y) {
            this.x = x;
            this.y = y;
        }
    }
}
