package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 안전 영역
public class N2468 {

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] map;
    static boolean[][] visited;
    static int N, answer = 0;
    static final int[] dx = {-1, 0 ,1 ,0};
    static final int[] dy = {0, 1, 0, -1};


    public static void BFS(int y, int x) {
        Queue<Point> queue = new LinkedList<>();
        visited[y][x] = true;
        queue.offer(new Point(x, y));
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < N && !visited[ny][nx]) {
                    visited[ny][nx] = true;
                    queue.offer(new Point(nx, ny));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        int maxH = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                int h = Integer.parseInt(st.nextToken());
                maxH = Math.max(maxH, h);
                map[i][j] = h;
            }
        }
        for (int i = 0; i <= maxH; i++) {
            int safety = 0;
            visited = new boolean[N][N];
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (map[j][k] <= i) {
                        visited[j][k] = true;
                    }
                }
            }
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    if (visited[j][k] == false) {
                        BFS(j, k);
                        safety++;
                    }
                }
            }
            answer = Math.max(answer, safety);
        }
        System.out.println(answer);
    }
}
