package org.example.kimtaewon.s5.stack;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 교육과정 설계
public class N7 {

    public static String solution(String required, String plan) {
        String answer = "NO";
        Queue<Character> queue = new LinkedList<>();
        for (char c : required.toCharArray()) {
            queue.offer(c);
        }
        for (char c : plan.toCharArray()) {
            if (!queue.isEmpty() && queue.peek() == c) {
                queue.poll();
            }
        }
        if (queue.isEmpty()) {
            answer = "YES";
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String required = sc.next();
        String plan = sc.next();
        System.out.println(solution(required, plan));
    }
}
