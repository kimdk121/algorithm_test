package org.example.kimtaewon.s8.dfs;

import java.util.Scanner;

// 최대점수 구하기
public class N3 {

    static int answer, n, totalTime = 0;
    static int[] score, time;

    public static void DFS(int L, int sumTime, int sumScore) {
        if (sumTime > totalTime) return;
        if (L == n) {
            answer = Math.max(sumScore, answer);
        } else {
            DFS(L+1, sumTime + time[L], sumScore + score[L]);
            DFS(L+1, sumTime, sumScore);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        totalTime = sc.nextInt();
        score = new int[n];
        time = new int[n];
        for (int i = 0; i < n; i++) {
            score[i] = sc.nextInt();
            time[i] = sc.nextInt();
        }
        DFS(0, 0, 0);
        System.out.println(answer);
    }
}
