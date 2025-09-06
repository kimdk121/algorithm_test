package org.example.baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

// DSLR
public class N9019 {

    static int n;
    static boolean[] visited = new boolean[10000];

    static class Node {
        int value;
        String build;
        Node(int value, String build) {
            this.value = value;
            this.build = build;
        }
    }

    public static void BFS(int A, int B) {
        Arrays.fill(visited, false);
        Queue<Node> queue = new LinkedList<>();
        visited[A] = true;
        queue.offer(new Node(A, ""));
        while (!queue.isEmpty()) {
            Node a = queue.poll();
            if (a.value == B) {
                System.out.println(a.build);
                break;
            }

            for (int i = 0; i < 4; i++) {
                int value = 0;
                String build = "";
                if (i==0) {
                    value = D(a.value);
                    build = "D";
                }
                if (i==1) {
                    value = S(a.value);
                    build = "S";
                }
                if (i==2) {
                    value = L(a.value);
                    build = "L";
                }
                if (i==3) {
                    value = R(a.value);
                    build = "R";
                }
                if (!visited[value]) {
                    visited[value] = true;
                    queue.offer(new Node(value, a.build + build));
                }
            }
        }
    }

    public static int D(int v) {
        return ((2 * v) % 10000);
    }

    public static int S(int v) {
        if (v < 1) {
            return 9999;
        } else {
            return v - 1;
        }
    }

    public static int L(int v) {
        return ((v % 1000) * 10) + (v / 1000);
    }

    public static int R(int v) {
        return (v / 10) + (v % 10) * 1000;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            BFS(A, B);
        }
    }
}
