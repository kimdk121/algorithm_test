package org.example.kimtaewon.s8.bfs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 토마토
public class N12 {

    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = new int[]{-1, 0, 1, 0};
    static int[] dy = new int[]{0, 1, 0, -1};
    static int[][] box, dis;
    static int n = 0, m = 0;

    public static void BFS() {
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 1) {
                    queue.offer(new Point(i, j));
                }
            }
        }
        while (!queue.isEmpty()) {
            Point tmp = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = tmp.x + dx[i];
                int ny = tmp.y + dy[i];
                if (nx >= 0 && nx < n && ny >= 0 && ny < m && box[nx][ny] == 0) {
                    box[nx][ny] = 1;
                    dis[nx][ny] = dis[tmp.x][tmp.y] + 1;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
        int a = 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        m = sc.nextInt();
        n = sc.nextInt();
        box = new int[n][m];
        dis = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                box[i][j] = sc.nextInt();
            }
        }
        BFS();
        boolean flag = true;
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (box[i][j] == 0) {
                    flag = false;
                }
                max = Math.max(max, dis[i][j]);
            }
        }
        if (flag) System.out.println(max);
        else System.out.println(-1);
    }
}
