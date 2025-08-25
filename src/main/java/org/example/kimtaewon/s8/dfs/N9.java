package org.example.kimtaewon.s8.dfs;

import java.util.Scanner;

// 조합 구하기
public class N9 {

    static int[] combi;
    static int n, m;

    public static void DFS(int L, int s) {
        if (L == m) {
            for (int i : combi) {
                System.out.print(i + " ");
            }
            System.out.println();
        } else {
            for (int i = s; i <= n; i++) {
                combi[L] = i;
                DFS(L+1, i+1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        combi = new int[m];
        DFS(0, 1);
    }
}
