package org.example.kimtaewon.s6.sorting;

import java.util.Scanner;

// 삽입정렬
public class N3 {

    private static int[] solution(int n, int[] nArr) {
        for (int i = 1; i < n; i++) {
            int tmp = nArr[i];
            int j;
            for (j = i-1; j >= 0; j--) {
                if (nArr[j] > tmp) {
                    nArr[j+1] = nArr[j];
                } else {
                    break;
                }
            }
            nArr[j+1] = tmp;
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
