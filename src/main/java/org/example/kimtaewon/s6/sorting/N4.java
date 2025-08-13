package org.example.kimtaewon.s6.sorting;

import java.util.Scanner;

// LRU
public class N4 {

    public static int[] solution(int size, int n, int[] nArr) {
        int[] cache = new int[size];
        for (int n1 : nArr) {
            int pos = -1;
            for (int i = 0; i < size; i++) {
                if (n1 == cache[i]) {
                    pos = i;
                }
            }
            if (pos == -1) {
                for (int i = size-1; i >= 1; i--) {
                    cache[i]=cache[i-1];
                }
            } else {
                for (int i = pos; i >= 1; i--) {
                    cache[i] = cache[i-1];
                }
            }
            cache[0] = n1;
        }
        return cache;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int size = sc.nextInt();
        int n = sc.nextInt();
        int[] nArr = new int[n];
        for (int i = 0; i < n; i++) {
            nArr[i] = sc.nextInt();
        }
        for (int i : solution(size, n, nArr)) {
            System.out.print(i + " ");
        }
    }
}
