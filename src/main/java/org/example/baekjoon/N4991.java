package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 로봇 청소기
public class N4991 {

    static class Point {
        int y; int x; int bit; int dist;
        Point(int y, int x, int bit, int dist) {
            this.y = y; this.x = x; this.bit = bit; this.dist = dist;
        }
    }
    static Point robot;
    static int w, h, maxDust;
    static char[][] map;
    static int[][] dustIdx;
    static boolean[][][] visited;
    static final int[] dx = {1, 0, -1, 0};
    static final int[] dy = {0, 1, 0, -1};

    static int BFS() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(robot);
        map[robot.y][robot.x] = '.';
        visited[robot.y][robot.x][0] = true;

        while (!queue.isEmpty()) {
            Point cur = queue.poll();

            if (cur.bit == (1 << maxDust) -1 ) {
                return cur.dist;
            }

            for (int i = 0; i < dx.length; i++) {
                int ny = cur.y + dy[i];
                int nx = cur.x + dx[i];

                if (ny < 0 || ny >= h || nx < 0 || nx >= w) continue;
                if (map[ny][nx] == 'x') continue;

                int nextBit = cur.bit;
                if (dustIdx[ny][nx] != -1) {
                    nextBit |= (1 << dustIdx[ny][nx]);
                }

                if (visited[ny][nx][nextBit]) continue;
                queue.offer(new Point(ny, nx, nextBit, cur.dist +1));
                visited[ny][nx][nextBit] = true;

            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(bf.readLine());
            w = Integer.parseInt(st.nextToken());
            h = Integer.parseInt(st.nextToken());

            if (w == 0 && h == 0) {
                break;
            }

            map = new char[h][w];
            dustIdx = new int[h][w];
            for (int i = 0; i < h; i++) {
                Arrays.fill(dustIdx[i], -1);
            }

            maxDust = 0;
            for (int i = 0; i < h; i++) {
                String str = bf.readLine();
                for (int j = 0; j < w; j++) {
                    char next = str.charAt(j);
                    map[i][j] = next;
                    if (next == 'o') {
                        robot = new Point(i, j, 0, 0);
                    } else if (next == '*') {
                        maxDust++;
                        dustIdx[i][j] = maxDust-1;
                    }
                }
            }
            visited = new boolean[h][w][1 << maxDust];

            System.out.println(BFS());
        }
    }
}
