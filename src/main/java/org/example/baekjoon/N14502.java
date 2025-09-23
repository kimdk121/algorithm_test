package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 연구소
public class N14502 {

    static class Point {
        int y; int x;
        Point(int y, int x) {
            this.y = y; this.x = x;
        }
    }
    static int N, M, answer = 0;
    static int[][] map;
    static List<Point> blank;
    static List<Point> virus;
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};

    static void DFS(int start, int cnt) {
        if (cnt == 3) {
            answer = Math.max(answer, BFS());
            return;
        }
        for (int i = start; i < blank.size(); i++) {
            Point point = blank.get(i);
            if (map[point.y][point.x] != 0) continue;

            map[point.y][point.x] = 1;
            DFS(i + 1, cnt + 1);
            map[point.y][point.x] = 0;
        }
    }

    static int BFS() {
        int[][] temp = new int[N][M];
        int safe = 0;
        for (int i = 0; i < map.length; i++) {
            temp[i] = map[i].clone();
        }
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < virus.size(); i++) {
            queue.offer(virus.get(i));
        }
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            for (int i = 0; i < dx.length; i++) {
                int nx = cur.x + dx[i];
                int ny = cur.y + dy[i];
                if (nx >= 0 && nx < M && ny >= 0 && ny < N) {
                    if (temp[ny][nx] == 0) {
                        temp[ny][nx] = 2;
                        queue.offer(new Point(ny, nx));
                    }
                }
            }
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (temp[i][j] == 0) safe++;
            }
        }
        return safe;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        blank = new ArrayList<>();
        virus = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < M; j++) {
                int next = Integer.parseInt(st.nextToken());
                map[i][j] = next;
                if (next == 0) {
                    blank.add(new Point(i, j));
                } else if (next == 2) {
                    virus.add(new Point(i, j));
                }
            }
        }
        DFS(0, 0);
        System.out.println(answer);
    }
}
