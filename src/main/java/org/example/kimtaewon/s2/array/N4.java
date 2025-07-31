package org.example.kimtaewon.s2.array;

import java.util.Scanner;

// 피보나치수열
public class N4 {

    public static int[] solution(int s) {
        int[] answer = new int[s];
        answer[0] = 1;
        answer[1] = 1;
        for (int i = 2; i < s; i++) {
            answer[i] = answer[i-2] + answer[i-1];
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        for (int i : solution(s)) {
            System.out.print(i + " ");
        }
    }
}
