package org.example.kimtaewon.s1.string;

import java.util.Scanner;

// 가장 짧은 문자거리 구하기
public class N10 {

    public static int[] solution(String str, char c) {
        int[] answer = new int[str.length()];
        int p = 1000;
        for (int i=0; i< str.length(); i++) {
            if (str.charAt(i) == c) {
                p =0;
                answer[i] = p;
            } else {
                p++;
                answer[i] = p;
            }
        }
        p = 1000;
        for (int i=str.length()-1; i>=0; i--) {
            if (str.charAt(i) == c) {
                p =0;
                answer[i] = p;
            } else {
                p++;
                if(answer[i] < p) continue;
                answer[i] = p;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        char c = sc.next().charAt(0);
        for (int i : solution(str, c)) {
            System.out.print(i + " ");
        }
    }
}
