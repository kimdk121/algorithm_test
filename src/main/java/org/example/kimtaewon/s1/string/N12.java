package org.example.kimtaewon.s1.string;

import java.util.Scanner;

// 암호 풀이 2진수 -> 10진수
public class N12 {

    public static String solution(int s, String str) {
        String answer = "";
        for (int i=0; i<s; i++) {
            String tmp = str.substring(0, 7).replace("#", "1").replace("*", "0");
            str = str.substring(7);
            answer += (char)Integer.parseInt(tmp, 2);
        }
        return answer;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        String str = sc.next();
        System.out.println(solution(s, str));
    }
}
