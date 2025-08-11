package org.example.kimtaewon.s5.stack;

import java.util.Scanner;
import java.util.Stack;

// 후위식 연산
public class N4 {

    public static int solution(String str) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c)) {
                stack.push(c-'0');
            } else {
                int rt = stack.pop();
                int lt = stack.pop();
                if(c == '+') stack.push(lt+rt);
                if(c == '-') stack.push(lt-rt);
                if(c == '*') stack.push(lt*rt);
                if(c == '/') stack.push(lt/rt);
            }
        }
        answer = stack.get(0);
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}
