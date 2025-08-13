package org.example.kimtaewon.s6.sorting;

import java.util.Scanner;

// 선택 정렬
public class N1 {

    public static int[] solution(int n, int[] nArr) {
        for (int i = 0; i < n-1; i++) {
            int idx = i;
            for (int j = i+1; j < n; j++) {
                if (nArr[j]<nArr[idx]) {
                    idx = j;
                }
            }
            int tmp = nArr[i];
            nArr[i] = nArr[idx];
            nArr[idx] = tmp;
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
