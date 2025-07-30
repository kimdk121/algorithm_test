package org.example.kimtaewon.s1.string;

import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

// 중복제거
public class N6 {

    public static String solution(String str) {
        String answer = "";
        for (int i =0; i<str.length(); i++) {
            if(str.indexOf(str.charAt(i)) == i) {
                answer += str.charAt(i);
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
