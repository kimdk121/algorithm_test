package org.example.kimtaewon.s10.dynamicprogramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 가장 높은 탑 쌓기
public class N4 {

    static class Brick implements Comparable<Brick> {
        int s;
        int h;
        int w;
        Brick(int s, int h, int w) {
            this.s = s;
            this.h = h;
            this.w = w;
        }

        @Override
        public int compareTo(Brick o) {
            return o.s - this.s;
        }
    }

    public static int solution(int n, ArrayList<Brick> bricks, int[] dy) {
        int answer = 0;
        Collections.sort(bricks);
        dy[0] = bricks.get(0).h;
        for (int i = 1; i < n; i++) {
            Brick now = bricks.get(i);
            int max = 0;
            for (int j = i-1; j >= 0; j--) {
                Brick before = bricks.get(j);
                if (before.w > now.w && dy[j] > max) {
                    max = dy[j];
                }
            }
            dy[i] = max + now.h;
            answer = Math.max(answer, dy[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Brick> bricks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            bricks.add(new Brick(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        int[] dy = new int[n];
        System.out.println(solution(n, bricks, dy));
    }
}
