package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 구슬탈출2
public class N13460 {

    static class State {
        int Ry, Rx, By, Bx, cnt;
        State(int Ry, int Rx, int By, int Bx, int cnt) {
            this.Ry = Ry; this.Rx = Rx; this.By = By; this.Bx = Bx; this.cnt = cnt;
        }
    }

    static class Roll {
        int y, x, cnt;
        boolean goal;
        Roll(int y, int x, int cnt, boolean goal) {
            this.y = y; this.x = x; this.cnt = cnt; this.goal = goal;
        }
    }

    public static Roll roll(int y, int x, int dir) {
        int cy = y; int cx = x; int cnt = 0;
        while (true) {
            int ny = cy + dy[dir]; int nx = cx + dx[dir];
            if (ny >= 0 && ny < N && nx >= 0 && nx < M) {
                if (map[ny][nx] == '#') {
                    break;
                } else if (map[ny][nx] == 'O') {
                    return new Roll(ny, nx, cnt += 1, true);
                } else {
                    cy = ny; cx = nx; cnt += 1;
                }
            }
        }
        return new Roll(cy, cx, cnt, false);
    }

    static int N, M, Ry, Rx, By, Bx;
    static char[][] map;
    static boolean[][][][] visited;
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};

    public static void BFS(State state) {
        Queue<State> queue = new LinkedList<>();
        map[state.Ry][state.Rx] = '.';
        map[state.By][state.Bx] = '.';
        visited[Ry][Rx][By][Bx] = true;
        queue.offer(state);
        while (!queue.isEmpty()) {
            State cur = queue.poll();
            // 11번째 굴리면 -1로 변경
            if (cur.cnt >= 10) {
                System.out.println(-1);
                return;
            }
            // 기울이기 4방향
            for (int dir = 0; dir < dx.length; dir++) {
                Roll red = roll(cur.Ry, cur.Rx, dir);
                Roll blue = roll(cur.By, cur.Bx, dir);
                // 구슬이 구멍에 빠진다
                if (blue.goal) continue;
                if (red.goal) {
                    System.out.println(cur.cnt+1);
                    return;
                }
                int nRy = red.y, nRx = red.x, nBy = blue.y, nBx = blue.x;
                // 구슬이 같은 위치면 더 멀리간 구슬이 한칸 뒤로간다
                if (nRy == nBy && nRx == nBx) {
                    if (red.cnt > blue.cnt) {
                        nRy = nBy - dy[dir];
                        nRx = nBx - dx[dir];
                    } else {
                        nBy = nRy - dy[dir];
                        nBx = nRx - dx[dir];
                    }
                }
                if (!visited[nRy][nRx][nBy][nBx]) {
                    visited[nRy][nRx][nBy][nBx] = true;
                    queue.offer(new State(nRy, nRx, nBy, nBx, cur.cnt +1 ));
                }
            }
        }
        System.out.println(-1);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new char[N][M];
        visited = new boolean[N][M][N][M];

        for (int i = 0; i < N; i++) {
            String str = bf.readLine();
            for (int j = 0; j < M; j++) {
                char next = str.charAt(j);
                if (next == 'R') {
                    Ry = i; Rx = j;
                } else if (next == 'B') {
                    By = i; Bx = j;
                }
                map[i][j] = next;
            }
        }
        BFS(new State(Ry, Rx, By, Bx, 0));
    }
}
