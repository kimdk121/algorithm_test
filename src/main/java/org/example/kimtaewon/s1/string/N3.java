package org.example.kimtaewon.s1.string;

import java.util.Scanner;

// 문장 속 단어
public class N3 {

    public static String solution(String str) {
        String answer = "";
        int max =0;
        for (String a : str.split(" ")) {
            if (a.length() > max) {
                max = a.length();
                answer = a;
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
