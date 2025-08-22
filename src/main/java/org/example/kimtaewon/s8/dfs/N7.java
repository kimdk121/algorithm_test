package org.example.kimtaewon.s8.dfs;

import java.util.Scanner;

// 조합수
public class N7 {

    public static int DFS(int n, int r) {
        if (n == r || r == 0) return 1;
        else return DFS(n-1, r-1)+DFS(n-1, r);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int r = sc.nextInt();
        System.out.println(DFS(n, r));
    }
}
