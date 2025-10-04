package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 미로탈출
public class N14923 {

    static class Point {
        int y; int x; int used;
        Point(int y, int x, int used) {
            this.y = y; this.x = x; this.used = used;
        }
    }

    static int N, M, Hx, Hy, Ex, Ey;
    static int[][] map;
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static int[][][] dist;

    static int BFS() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(new Point(Hy, Hx, 0));
        dist[Hy][Hx][0] = 0;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            if (cur.y == Ey && cur.x == Ex) {
                return dist[cur.y][cur.x][cur.used];
            }

            for (int i = 0; i < dx.length; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                int nUsed = cur.used;

                if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;
                if (map[ny][nx] == 1) {
                    if (cur.used == 1) continue;
                    nUsed = 1;
                }
                if (dist[ny][nx][nUsed] != -1) continue;
                dist[ny][nx][nUsed] = dist[cur.y][cur.x][cur.used] + 1;
                queue.offer(new Point(ny, nx, nUsed));
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        Hy = Integer.parseInt(st.nextToken()) -1;
        Hx = Integer.parseInt(st.nextToken()) -1;

        st = new StringTokenizer(bf.readLine());
        Ey = Integer.parseInt(st.nextToken()) -1;
        Ex = Integer.parseInt(st.nextToken()) -1;

        map = new int[N][M];
        dist = new int[N][M][2];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                Arrays.fill(dist[i][j], -1);
            }
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(BFS());
    }
}
