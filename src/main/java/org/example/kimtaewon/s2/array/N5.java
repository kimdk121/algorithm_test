package org.example.kimtaewon.s2.array;

import java.util.Scanner;

// 소수 구하기 에라토스테네스 체
public class N5 {

    public static int solution(int s) {
        int answer = 0;
        int[] sArr = new int[s+1];
        for (int i = 2; i < s; i++) {
            if (sArr[i] == 0) {
                answer++;
                for (int j = 0; j < s; j = j+i) {
                    sArr[j] = 1;
                }
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        System.out.println(solution(s));
    }
}
