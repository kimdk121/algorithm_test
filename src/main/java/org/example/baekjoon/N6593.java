package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 상범 빌딩
public class N6593 {

    static class Point {
        int z, y, x;
        Point(int z, int y, int x) {
            this.z = z;
            this.y = y;
            this.x = x;
        }
    }

    static int L, R, C;
    static char[][][] building;
    static boolean[][][] visited;
    static final int[] dx = {0, 0, -1, 0, 1, 0};
    static final int[] dy = {0, 0, 0, 1, 0, -1};
    static final int[] dz = {-1, 1, 0, 0, 0, 0};

    public static int BFS(Point start) {
        Queue<Point> queue = new LinkedList<>();
        visited[start.z][start.y][start.x] = true;
        queue.offer(start);
        int minutes = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point cur = queue.poll();
                if (building[cur.z][cur.y][cur.x] == 'E') {
                    return minutes;
                }
                for (int j = 0; j < dx.length; j++) {
                    int nx = cur.x + dx[j];
                    int ny = cur.y + dy[j];
                    int nz = cur.z + dz[j];

                    if (nx >= 0 && nx < C && ny >= 0 && ny < R && nz >= 0 && nz < L
                            && visited[nz][ny][nx] == false && building[nz][ny][nx] != '#') {
                        visited[nz][ny][nx] = true;
                        queue.offer(new Point(nz, ny, nx));
                    }
                }
            }
            minutes ++;
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            StringTokenizer st = new StringTokenizer(bf.readLine());

            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            building = new char[L][R][C];
            visited = new boolean[L][R][C];
            Point start = null;
            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String line = bf.readLine();
                    for (int k = 0; k < C; k++) {
                        char c = line.charAt(k);
                        if (c == 'S') {
                            start = new Point(i, j, k);
                        } else if (c == '#') {
                            visited[i][j][k] = true;
                        }
                        building[i][j][k] = c;
                    }
                }
                bf.readLine();
            }
            int answer = BFS(start);
            if (answer == -1) {
                System.out.println("Trapped!");
            } else {
                System.out.println("Escaped in " + answer + " minute(s).");
            }
        }
    }
}
