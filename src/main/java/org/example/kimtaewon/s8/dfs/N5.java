package org.example.kimtaewon.s8.dfs;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

// 동전교환
public class N5 {

    static int n, m, answer = Integer.MAX_VALUE;
    static Integer[] arr;

    public static void DFS(int L, int sum) {
        if(sum > m) return;
        if(L>=answer) return;
        if (sum == m) {
            answer = Math.min(answer, L);
        } else {
            for (int i = 0; i < n; i++) {
                DFS(L+1, sum + arr[i]);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        Arrays.sort(arr, Collections.reverseOrder());
        m = sc.nextInt();
        DFS(0, 0);
        System.out.println(answer);
    }
}
