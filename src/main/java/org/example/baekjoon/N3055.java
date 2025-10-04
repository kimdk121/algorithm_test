package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 탈출
public class N3055 {

    static class Point {
        int y; int x;
        Point(int y, int x) {
            this.y = y; this.x = x;
        }
    }

    static int R, C, answer = 0;
    static char[][] map;
    static boolean[][] visited;
    static List<Point> waters;

    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};

    public static void BFS(Point me) {
        Queue<Point> meQueue = new LinkedList<>();
        Queue<Point> waterQueue = new LinkedList<>();
        meQueue.offer(me);
        for (Point water : waters) {
            waterQueue.offer(water);
        }
        visited[me.y][me.x] = true;
        map[me.y][me.x] = '.';
        
        while (!meQueue.isEmpty()) {
            int waterSize = waterQueue.size();
            for (int i = 0; i < waterSize; i++) {
                Point point = waterQueue.poll();
                for (int j = 0; j < dx.length; j++) {
                    int ny = point.y + dy[j];
                    int nx = point.x + dx[j];
                    if (ny >= 0 && ny < R && nx >= 0 && nx < C) {
                        if (map[ny][nx] == '.') {
                            map[ny][nx] = '*';
                            waterQueue.offer(new Point(ny, nx));
                        }
                    }
                }
            }
            int meSize = meQueue.size();
            for (int i = 0; i < meSize; i++) {
                Point cur = meQueue.poll();
                for (int j = 0; j < dx.length; j++) {
                    int ny = cur.y + dy[j];
                    int nx = cur.x + dx[j];
                    if (ny >= 0 && ny < R && nx >= 0 && nx < C) {
                        if (map[ny][nx] == 'D') {
                            answer++;
                            return;
                        }
                        if (!visited[ny][nx] && map[ny][nx] == '.') {
                            visited[ny][nx] = true;
                            meQueue.offer(new Point(ny, nx));
                        }
                    }
                }
            }
            answer++;
        }
        answer = -1;
        return;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        visited = new boolean[R][C];

        waters = new ArrayList<>();
        Point me = null;
        for (int i = 0; i < R; i++) {
            String str = bf.readLine();
            for (int j = 0; j < C; j++) {
                char next = str.charAt(j);
                map[i][j] = next;
                if (next == '*') {
                    waters.add(new Point(i, j));
                } else if (next == 'S') {
                    me = new Point(i, j);
                }
            }
        }
        BFS(me);
        System.out.println(answer == -1 ? "KAKTUS" : answer);
    }
}
