package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 숫자판 점프
public class N2210 {

    static int[][] map;
    static final int[] dx = {-1, 0, 1, 0};
    static final int[] dy = {0, 1, 0, -1};
    static HashSet<String> list;

    static void DFS(int y, int x, int depth, String str) {
        if (depth == 7) {
            list.add(str);
            return;
        }
        str = str + map[y][x];

        for (int i = 0; i < dx.length; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny >= 0 && nx >= 0 && ny < 5 && nx < 5) {
                DFS(ny, nx, depth+1, str);
            }
        }
        
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        map = new int[5][5];
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 0; j < 5; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        list = new HashSet<>();

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                DFS(i, j, 1, "");
            }
        }
        System.out.println(list.size());
    }
}
