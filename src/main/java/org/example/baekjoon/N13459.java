package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 구슬 탈출
public class N13459 {

    static class State {
        int Ry, Rx, By, Bx, cnt;
        State(int Ry, int Rx, int By, int Bx, int cnt) {
            this.Ry = Ry;
            this.Rx = Rx;
            this.By = By;
            this.Bx = Bx;
            this.cnt = cnt;
        }
    }

    static class Roll {
        int y, x, cnt; boolean goal;
        Roll(int y, int x, int cnt, boolean goal) {
            this.y = y;
            this.x = x;
            this.cnt = cnt;
            this.goal = goal;
        }
    }

    static int N, M, Rx = 0, Ry = 0, Bx = 0, By = 0, Gx = 0, Gy = 0;
    static char[][] map;
    static boolean[][][][] visited;
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};

    public static Roll roll(int y, int x, int dir) {
        int cy = y, cx = x, cnt = 0;
        while (true) {
            int ny = cy + dy[dir];
            int nx = cx + dx[dir];
            if (map[ny][nx] == '#') {
                break;
            }
            cnt++; cy = ny; cx = nx;
            if (map[cy][cx] == 'O') {
                return new Roll(cy, cx, cnt, true);
            }
        }
        return new Roll(cy, cx, cnt, false);
    }

    public static int BFS() {
        Queue<State> queue = new LinkedList<>();
        visited[Ry][Rx][By][Bx] = true;
        map[Ry][Rx] = '.';
        map[By][Bx] = '.';
        queue.offer(new State(Ry, Rx, By, Bx, 0));

        while (!queue.isEmpty()) {
            State cur = queue.poll();

            if (cur.cnt >= 10) continue;

            for (int dir = 0; dir < dx.length; dir++) {
                Roll red = roll(cur.Ry, cur.Rx, dir);
                Roll blue = roll(cur.By, cur.Bx, dir);

                // 골일경우
                if (blue.goal) continue;
                if (red.goal) return 1;

                int nRy = red.y, nRx = red.x, nBy = blue.y, nBx = blue.x;

                // 겹칠경우
                if (nRy == nBy && nRx == nBx) {
                    if (red.cnt > blue.cnt) {
                        nRx = nRx - dx[dir];
                        nRy = nRy - dy[dir];
                    } else {
                        nBx = nBx - dx[dir];
                        nBy = nBy - dy[dir];
                    }
                }

                if (!visited[nRy][nRx][nBy][nBx]) {
                    visited[nRy][nRx][nBy][nBx] = true;
                    queue.offer(new State(nRy, nRx, nBy, nBx, cur.cnt+1));
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new char[N][M];

        for (int i = 0; i < N; i++) {
            String line = bf.readLine();
            for (int j = 0; j < M; j++) {
                char c = line.charAt(j);
                if (c == 'R') {
                    Ry = i;
                    Rx = j;
                } else if (c == 'B') {
                    By = i;
                    Bx = j;
                } else if (c == 'O') {
                    Gy = i;
                    Gx = j;
                }
                map[i][j] = c;
            }
        }

        visited = new boolean[N][M][N][M];
        int answer = BFS();
        System.out.println(answer);
    }
}
