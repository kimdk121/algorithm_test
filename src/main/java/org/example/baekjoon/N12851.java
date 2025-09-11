package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// 숨바꼭질 2
public class N12851 {

    static int N, K;
    static int[] dist, cnt;

    public static void BFS() {
        Queue<Integer> queue = new LinkedList<>();
        dist[N] = 0;
        cnt[N] = 1;
        queue.offer(N);
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            int nextTime = dist[cur] + 1;
            int[] next = {cur + 1, cur -1, cur * 2};
            for (int nx : next) {
                if (nx < 0 || nx > 100000) continue;
                if (dist[nx] == -1) {
                    dist[nx] = nextTime;
                    cnt[nx] = cnt[cur];
                    queue.offer(nx);
                } else if (dist[nx] == nextTime) {
                    cnt[nx] += cnt[cur];
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        dist = new int[100001];
        cnt = new int[100001];
        Arrays.fill(dist, -1);
        BFS();
        System.out.println(dist[K]);
        System.out.println(cnt[K]);
    }
}
