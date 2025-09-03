package org.example.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

// 알파벳
public class N1987 {

    static int w, h, answer = 0;
    static int[][] arr;
    static boolean[] ch;
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};


    public static void DFS(int L, int y, int x) {
        answer = Math.max(L, answer);

        int alphabet = arr[y][x] - 'A';
        ch[alphabet] = true;

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < w && ny < h) {
                int nextAlphabet = arr[ny][nx] - 'A';
                if (!ch[nextAlphabet]) {
                    DFS(L+1, ny, nx);
                }
            }
        }
        ch[alphabet] = false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        h = sc.nextInt();
        w = sc.nextInt();
        arr = new int[h][w];
        ch = new boolean[26];
        for (int i = 0; i < h; i++) {
            String str = sc.next();
            for (int j = 0; j < w; j++) {
                arr[i][j] = str.charAt(j);
            }
        }
        DFS(1, 0, 0);
        System.out.println(answer);
    }
}
