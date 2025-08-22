package org.example.kimtaewon.s7.tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 송아지 찾기 1
public class N8 {

    static int answer = 0;
    static int[] dis = {1, -1, 5};
    static int[] ch;
    static Queue<Integer> queue = new LinkedList<>();

    public static int BFS(int s, int e) {
        ch = new int[10001];
        ch[s] = 1;
        queue.offer(s);
        int L = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int x = queue.poll();
                for (int j = 0; j < dis.length; j++) {
                    int nx = x + dis[j];
                    if (nx == e) return L+1;
                    if (nx >= 1 && nx <= 10000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        queue.offer(nx);
                    }
                }
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int e = sc.nextInt();
        System.out.println(BFS(s, e));
    }
}
