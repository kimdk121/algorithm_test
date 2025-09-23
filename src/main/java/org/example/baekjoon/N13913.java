package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 숨바꼭질 4
public class N13913 {

    static int N, K;
    static final int MAX = 100000;
    static int[] dist, prev;


    public static void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(N);
        dist[N] = 0;
        while (!queue.isEmpty()) {
            int cur = queue.poll();

            if (cur == K) {
                List<Integer> path = new ArrayList<>();
                for (int v = K; v != -1; v = prev[v]) path.add(v);
                Collections.reverse(path);

                StringBuilder sb = new StringBuilder();
                sb.append(dist[K]).append('\n');
                for (Integer i : path) {
                    sb.append(i).append(' ');
                }
                System.out.println(sb.toString().trim());
                return;
            }

            int[] oper = {cur + 1, cur - 1, cur * 2};
            int nextTime = dist[cur] + 1;
            for (int nx : oper) {
                if (nx >= 0 && nx <= MAX) {
                    if (dist[nx] == -1) {
                        dist[nx] = nextTime;
                        prev[nx] = cur;
                        queue.offer(nx);
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException { 
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new int[MAX + 1];
        prev = new int[MAX + 1];
        Arrays.fill(dist, -1);
        Arrays.fill(prev, -1);

        BFS();
    }
}
