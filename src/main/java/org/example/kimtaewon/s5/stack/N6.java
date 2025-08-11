package org.example.kimtaewon.s5.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 공주 구하기
public class N6 {

    public static int solution(int n, int m) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < n+1; i++) {
            queue.offer(i);
        }
        while (queue.size() > 1) {
            for (int i = 1; i < m; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
        }
        answer = queue.poll();
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        System.out.println(solution(n, m));
    }
}
