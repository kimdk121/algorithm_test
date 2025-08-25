package org.example.kimtaewon.s8.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 섬나라 아일랜드
public class N14 {

    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
    static int[] dy = new int[]{1, 1, 0, -1, -1, -1, 0, 1};
    static int n = 0, answer = 0;
    static int[][] island;

    public static void BFS(int x, int y) {
        Queue<Point> queue = new LinkedList<>();
        island[x][y] = 0;
        queue.offer(new Point(x, y));

        while (!queue.isEmpty()) {
            Point tmp = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < n && island[nx][ny] == 1) {
                    island[nx][ny] = 0;
                    queue.offer(new Point(nx, ny));
                }
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
                    BFS(i, j);
                    answer++;
                }
            }
        }
        System.out.println(answer);
    }
}
