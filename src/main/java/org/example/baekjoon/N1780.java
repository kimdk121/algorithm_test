package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 종이의 개수
public class N1780 {

    static int N, zero = 0, plus = 0, minus = 0;
    static int[][] paper;

    static void rec(int y, int x, int n) {
        boolean flag = checkPlace(y, x, n);
        if (flag) {
            int num = paper[y][x];
            if (num == 1) {
                plus++;
            } else if (num == 0) {
                zero++;
            } else {
                minus++;
            }
            return;
        }
        int m = n / 3;
        rec(y, x, m);
        rec(y, x + m, m);
        rec(y, x + 2 * m, m);

        rec(y + m, x, m);
        rec(y + m, x + m, m);
        rec(y + m, x + 2 * m, m);

        rec(y + 2 * m, x, m);
        rec(y + 2 * m, x + m, m);
        rec(y + 2 * m, x + 2 * m, m);
    }

    static boolean checkPlace(int y, int x, int n) {
        int first = paper[y][x];
        for (int i = y; i < y + n ; i++) {
            for (int j = x; j < x + n; j++) {
                if (first != paper[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        paper = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        rec(0, 0, N);
        System.out.println(minus);
        System.out.println(zero);
        System.out.println(plus);
    }
}
