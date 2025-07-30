package org.example.kimtaewon.s1.string;

import java.util.Scanner;

// 대소문자 변환
public class N2 {

    public static String solution(String str) {
        String answer = "";
        for (char a : str.toCharArray()) {
            if (Character.isLowerCase(a)) {
                answer += Character.toUpperCase(a);
            } else {
                answer += Character.toLowerCase(a);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        System.out.println(solution(str));
    }
}
