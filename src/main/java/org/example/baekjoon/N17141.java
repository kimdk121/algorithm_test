package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 연구소 2
public class N17141 {

    static class Point {
        int y, x;
        Point(int y, int x) {
            this.y = y; this.x = x;
        }
    }

    static int N, M, answer = Integer.MAX_VALUE;
    static int[][] map;
    static List<Point> virus;
    static boolean[] pick;
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};

    static void DFS(int start, int cnt) {
        if (cnt == M) {
            answer = Math.min(answer, BFS());
            return;
        }
        for (int i = start; i < virus.size(); i++) {
            pick[i] = true;
            DFS(i + 1, cnt + 1);
            pick[i] = false;
        }
    }

    static int BFS() {
        int[][] dist = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dist[i], -1);
        }

        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < virus.size(); i++) {
            if (pick[i]) {
                Point point = virus.get(i);
                dist[point.y][point.x] = 0;
                queue.offer(new Point(point.y, point.x));
            }
        }

        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];
                if (ny >= 0 && ny < N && nx >= 0 && nx < N) {
                    if (map[ny][nx] != 1 && dist[ny][nx] == -1) {
                        dist[ny][nx] = dist[cur.y][cur.x] + 1;
                        queue.offer(new Point(ny, nx));
                    }
                }
            }
        }

        int max = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] != 1) {
                    if (dist[i][j] == -1) {
                        return Integer.MAX_VALUE;
                    }
                    max = Math.max(max, dist[i][j]);
                }
            }
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        virus = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                int next = Integer.parseInt(st.nextToken());
                map[i][j] = next;
                if (next == 2) {
                    virus.add(new Point(i, j));
                }
            }
        }
        pick = new boolean[virus.size()];
        DFS(0, 0);
        System.out.println(answer==Integer.MAX_VALUE ? -1 : answer);
    }
}
