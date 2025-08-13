package org.example.kimtaewon.s6.sorting;

import java.util.Scanner;

// 버블 정렬
public class N2 {

    public static int[] solution(int n, int[] nArr) {
        for (int i = 0; i < n-1; i++) {
            for (int j = 0; j < n-i-1; j++) {
                if (nArr[j]>nArr[j+1]) {
                    int tmp = nArr[j];
                    nArr[j] = nArr[j+1];
                    nArr[j+1] = tmp;
                }
            }
        }
        return nArr;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nArr = new int[n];
        for (int i = 0; i < n; i++) {
            nArr[i] = sc.nextInt();
        }
        for (Integer i : solution(n, nArr)) {
            System.out.print(i + " ");
        }
    }
}
