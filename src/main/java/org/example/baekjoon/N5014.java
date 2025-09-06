package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 스타트링크
public class N5014 {

    static int F, S, G, U, D;
    static int[] dist;

    public static void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(S);
        dist[S] = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            if (cur == G) {
                System.out.println(dist[cur]);
                return;
            }

            int up = cur + U;
            if (U > 0 && up <= F && dist[up] == -1) {
                dist[up] = dist[cur] + 1;
                queue.offer(up);
            }

            int down = cur - D;
            if (D > 0 && down >= 1 && dist[down] == -1) {
                dist[down] = dist[cur] + 1;
                queue.offer(down);
            }
        }
        System.out.println("use the stairs");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        dist = new int[F+1];
        Arrays.fill(dist, -1);
        BFS();
    }
}
