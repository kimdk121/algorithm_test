package org.example.kimtaewon.s8.dfs;

import java.util.ArrayList;
import java.util.Scanner;

// 피자배달거리
public class N15 {

    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int n = 0, m = 0, answer = Integer.MAX_VALUE, len = 0;
    static int[] combi;
    static ArrayList<Point> pizzaArray = new ArrayList<>()
            , homeArray = new ArrayList<>();

    public static void DFS(int L, int s) {
        if (L == m) {
            int sum = 0;
            for (Point home : homeArray) {
                int dis = Integer.MAX_VALUE;
                for (int i : combi) {
                    dis = Math.min(dis, Math.abs(home.x - pizzaArray.get(i).x)
                            + Math.abs(home.y - pizzaArray.get(i).y));
                }
                sum += dis;
            }
            answer = Math.min(answer, sum);
        } else {
            for (int i = s; i < len; i++) {
                combi[L] = i;
                DFS(L+1, i+1);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int next = sc.nextInt();
                if (next == 1) {
                    homeArray.add(new Point(i, j));
                } else if (next == 2) {
                    pizzaArray.add(new Point(i, j));
                }
            }
        }
        combi = new int[m];
        len = pizzaArray.size();
        DFS(0,0);
        System.out.println(answer);
    }
}
