package org.example.kimtaewon.s1.string;

import java.util.Scanner;

// 회문 문자열
public class N7 {

    public static String solution(String str) {
        String answer = "YES";
        str = str.toLowerCase();
        int len = str.length();
        for (int i=0; i<len/2; i++) {
            if(str.charAt(i) != str.charAt(len-i-1)) {
                return "NO";
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str));
    }
}
