package org.example.kimtaewon.s8.dfs;

import java.util.Scanner;

// 바둑이 승차
public class N2 {


    static int n, max, answer = 0;
    static int[] dogs;

    public static void DFS(int L, int sum) {
        if (sum > max) {
            return;
        }
        if(L == n) {
            answer = Math.max(sum, answer);
        }
        else {
            DFS(L+1, sum + dogs[L]);
            DFS(L+1, sum);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        max = sc.nextInt();
        n = sc.nextInt();
        dogs = new int[n];
        for (int i = 0; i < n; i++) {
            dogs[i] = sc.nextInt();
        }
        DFS(0, 0);
        System.out.println(answer);
    }
}
