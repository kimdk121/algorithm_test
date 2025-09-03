package org.example.baekjoon;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 영역 구하기 DFS
public class N2583 {

    static int h, w, n, sum, answer = 0;
    static int[][] field;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static ArrayList<Integer> area = new ArrayList<>();

    public static void DFS(int y, int x) {
        field[y][x] = 1;
        sum++;

        for (int i = 0; i < dx.length; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && nx < w && ny >= 0 && ny < h && field[ny][nx] == 0) {
                DFS(ny, nx);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        h = sc.nextInt();
        w = sc.nextInt();
        field = new int[h][w];
        n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            int x1 = sc.nextInt();
            int y1 = sc.nextInt();
            int x2 = sc.nextInt();
            int y2 = sc.nextInt();

            for (int y = y1; y < y2; y++) {
                for (int x = x1; x < x2; x++) {
                    field[y][x] = 1;
                }
            }
        }

        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                if (field[y][x] == 0) {
                    answer++;
                    sum = 0;
                    DFS(y, x);
                    area.add(sum);
                }
            }
        }

        Collections.sort(area);

        System.out.println(answer);
        for (int i : area) {
            System.out.print(i + " ");
        }
    }
}
