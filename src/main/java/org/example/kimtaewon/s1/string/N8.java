package org.example.kimtaewon.s1.string;

import java.util.Scanner;

// 회문문자열 팰린드롬 정규식 사용
public class N8 {

    public static String solution(String str) {
        String answer = "NO";
        str = str.toLowerCase().replaceAll("[^a-z]", "");
        String tmp = new StringBuilder(str).reverse().toString();
        if(tmp.equals(str)) return "YES";
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str));
    }
}
