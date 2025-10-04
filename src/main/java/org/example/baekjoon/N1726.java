package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 로봇
public class N1726 {

    static class Point {
        int y; int x; int dir;
        Point(int y, int x, int dir) {
            this.y = y; this.x = x; this.dir = dir;
        }
    }

    static int M, N;
    static int[][] map;
    static int[][][] dist;
    static Point start, end;
    static final int[] dy = {0, 1, 0, -1};
    static final int[] dx = {1, 0, -1, 0};

    static int BFS() {
        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);
        dist[start.y][start.x][start.dir] = 0;
        
        while (!queue.isEmpty()) {
            Point cur = queue.poll();
            if (cur.y == end.y && cur.x == end.x && cur.dir == end.dir) {
                return dist[cur.y][cur.x][cur.dir];
            }
            // 방향전환
            turn(cur.y, cur.x, cur.dir, queue);
            // 전진
            go(cur.y, cur.x, cur.dir, queue);
        }
        return -1;
    }

    static void go (int y, int x, int dir, Queue<Point> queue) {

        for (int i = 1; i <= 3; i++) {
            int ny = y + dy[dir] * i;
            int nx = x + dx[dir] * i;

            if (ny < 0 || ny >= M || nx < 0 || nx >= N) break;
            if (map[ny][nx] == 1) break;
            if (dist[ny][nx][dir] > dist[y][x][dir] + 1) {
                dist[ny][nx][dir] = dist[y][x][dir] + 1;
                queue.offer(new Point(ny, nx, dir));
            }
        }
    }

    static void turn (int y, int x, int dir, Queue<Point> queue) {
        // 왼쪽전환
        int leftDir = (dir +3) % 4;
        if (dist[y][x][leftDir] > dist[y][x][dir] + 1) {
            dist[y][x][leftDir] = dist[y][x][dir] + 1;
            queue.offer(new Point(y, x, leftDir));
        }

        // 오른쪽 전환
        int rightDir = (dir +1) % 4;
        if (dist[y][x][rightDir] > dist[y][x][dir] + 1) {
            dist[y][x][rightDir] = dist[y][x][dir] + 1;
            queue.offer(new Point(y, x, rightDir));
        }
    }

    static int convDir(int d) {
        int[] change = {-1, 0, 2, 1, 3};
        return change[d];
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        map = new int[M][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dist = new int[M][N][4];
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                Arrays.fill(dist[i][j], Integer.MAX_VALUE);
            }
        }

        st = new StringTokenizer(bf.readLine());
        int sy = Integer.parseInt(st.nextToken()) -1;
        int sx = Integer.parseInt(st.nextToken()) -1;
        int sDir = Integer.parseInt(st.nextToken());
        int convSDir = convDir(sDir);
        start = new Point(sy, sx, convSDir);

        st = new StringTokenizer(bf.readLine());
        int ey = Integer.parseInt(st.nextToken()) -1;
        int ex = Integer.parseInt(st.nextToken()) -1;
        int eDir = Integer.parseInt(st.nextToken());
        int convEDir = convDir(eDir);
        end = new Point(ey, ex, convEDir);

        System.out.println(BFS());
    }
}
