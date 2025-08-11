package org.example.kimtaewon.s5.stack;

import java.util.Scanner;
import java.util.Stack;

// 쇠막대기
public class N5 {

    public static int solution(String str) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();
        char prev = 0;
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                    stack.pop();
                if (prev == '(') {
                    answer += stack.size();
                } else {
                    answer ++;
                }
            }
            prev = c;
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}
