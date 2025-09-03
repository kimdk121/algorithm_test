package org.example.baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 단지번호붙이기
public class N2667 {

    static int n, sum = 0, answer = 0;
    static int[][] field;
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static ArrayList<Integer> arr = new ArrayList<>();

    public static void DFS(int y, int x) {
        sum++;
        field[y][x] = 0;
        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < n && ny < n && field[ny][nx] == 1) {
                DFS(ny, nx);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        field = new int[n][n];
        for (int i = 0; i < n; i++) {
            String str = sc.next();
            for (int j = 0; j < n; j++) {
                field[i][j] = str.charAt(j) - '0';
            }
        }
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < n; x++) {
                if (field[y][x] == 1) {
                    answer++;
                    sum = 0;
                    DFS(y, x);
                    arr.add(sum);
                }
            }
        }
        Collections.sort(arr);
        System.out.println(answer);
        for (int i : arr) {
            System.out.println(i);
        }
    }
}
