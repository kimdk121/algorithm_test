package org.example.kimtaewon.s9.greedy;

import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;

// 원더랜드 프림 PriorityQueue
public class N8 {

    static class Edge implements Comparable<Edge> {
        int v;
        int cost;
        Edge(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return this.cost - o.cost;
        }
    }

    static int[] ch;
    static int n = 0, m = 0;
    static ArrayList<ArrayList<Edge>> graph;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        ch = new int[n+1];
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            graph.get(a).add(new Edge(b, c));
            graph.get(b).add(new Edge(a, c));
        }
        int answer = 0;
        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(1, 0));
        while (!pq.isEmpty()) {
            Edge next = pq.poll();
            int nextv = next.v;
            if (ch[nextv] == 0) {
                ch[nextv] = 1;
                answer += next.cost;
                for (Edge edge : graph.get(nextv)) {
                    if (ch[edge.v] != 1) {
                        pq.offer(edge);
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
