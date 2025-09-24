package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 미로 탈출하기
public class N17090 {

    static int N, M, answer = 0;
    static char[][] map;
    static int[][] state;
    static int[][] dp;

    static void DFS(int y, int x) {
        if (state[y][x] != 0) return;
        state[y][x] = 1;

        int nx = x, ny = y;
        switch (map[y][x]) {
            case 'U' : ny = y - 1; break;
            case 'R' : nx = x + 1; break;
            case 'D' : ny = y + 1; break;
            case 'L' : nx = x - 1; break;
        }

        if (ny < 0 || ny >= N || nx < 0 || nx >= M) {
            dp[y][x] = 1;
            state[y][x] = 2;
            return;
        }

        if (state[ny][nx] == 0) {
            DFS(ny, nx);
            dp[y][x] = dp[ny][nx];
        } else if (state[ny][nx] == 1) {
            dp[y][x] = 0;
        } else {
            dp[y][x] = dp[ny][nx];
        }
        state[y][x] = 2;
    }


    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        state = new int[N][M];
        dp = new int[N][M];

        for (int i = 0; i < N; i++) {
            String next = bf.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = next.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                DFS(i, j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                answer += dp[i][j];
            }
        }
        System.out.println(answer);
    }
}
