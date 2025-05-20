package org.example.baekjoon;

import java.util.*;

public class N11720 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        String y = sc.next();

        List<Integer> array = new ArrayList<>();
        for (int i=0; i < y.length(); i++) {
            array.add(Integer.parseInt(y.substring(i,i+1)));
        }
        System.out.println(array.stream().mapToInt(value -> value.intValue()).sum());
    }
}

