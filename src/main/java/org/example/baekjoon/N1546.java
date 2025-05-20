package org.example.baekjoon;

import java.util.Scanner;

public class N1546 {

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long sum = 0;
        long max = 0;

        for (int i=0; i<N; i++) {
            int param = sc.nextInt();
            if (max<param) {
                max = param;
            }
            sum = sum + param;
        }
        System.out.println(sum*100.0/max/N);
    }
}
