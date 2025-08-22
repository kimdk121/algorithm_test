package org.example.kimtaewon.s8.dfs;

import java.util.Scanner;

// 순열 구하기
public class N6 {

    static int n, m = 0;
    static int[] arr;
    static int[] ch;

    public static void DFS(int L, int[] arr2) {
        if(L == m) {
            for (int i = 0; i < m; i++) {
                System.out.print(arr2[i] + " ");
            }
            System.out.println();
        } else {
            for (int i = 0; i < n; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    arr2[L] = arr[i];
                    DFS(L+1, arr2);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new int[n];
        ch = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        DFS(0, new int[m]);
    }
}
