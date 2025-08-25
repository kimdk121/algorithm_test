package org.example.kimtaewon.s8.dfs;

import java.util.Scanner;

// 섬나라 아일랜드
public class N13 {

    static int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
    static int n = 0, answer = 0;
    static int[][] island;

    public static void DFS(int x, int y) {
        island[x][y] = 0;
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < n && ny >= 0 && ny < n && island[nx][ny] == 1) {
                island[x][y] = 0;
                DFS(nx, ny);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        island = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                island[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (island[i][j] == 1) {
                    DFS(i, j);
                    answer++;
                }

            }
        }
        System.out.println(answer);
    }
}
