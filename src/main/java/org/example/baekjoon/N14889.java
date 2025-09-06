package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 스타트와 링크
public class N14889 {

    static int n, answer = Integer.MAX_VALUE;
    static int[][] arr;
    static boolean[] startTeam;

    public static void DFS(int L, int teamCount) {
        if (teamCount > n/2) return;
        if (L == n) {
            if (teamCount == n / 2) {
                int start = 0;
                int link = 0;

                for (int i = 0; i < n; i++) {
                    for (int j = i + 1; j < n; j++) {
                        if (startTeam[i] && startTeam[j]) {
                            start += arr[i][j] + arr[j][i];
                        } else if (!startTeam[i] && !startTeam[j]){
                            link += arr[i][j] + arr[j][i];
                        }
                    }
                }
                answer = Math.min(answer, Math.abs(start - link));
            }
        } else {
            startTeam[L] = true;
            DFS(L+1, teamCount+1);

            startTeam[L] = false;
            DFS(L+1, teamCount);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        arr = new int[n][n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        startTeam = new boolean[n];
        DFS(0, 0);
        System.out.println(answer);
    }
}
