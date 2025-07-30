package org.example.kimtaewon.s1.string;

import java.util.Scanner;

// 숫자만 추출
public class N9 {

    public static int solution(String str) {
        String answer = "";
        for (char a : str.toCharArray()) {
            if(Character.isDigit(a)) {
                answer += a;
            }
        }
        return Integer.parseInt(answer);
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str));
    }
}
