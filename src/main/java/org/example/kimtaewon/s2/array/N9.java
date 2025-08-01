package org.example.kimtaewon.s2.array;

import java.util.Scanner;

// 격자판 최대합 구하기
public class N9 {

    public static int solution(int s, int[][] sArr) {
        int answer = 0;
        int sum1;
        int sum2;
        for (int i = 0; i < s; i++) {
            sum1 = sum2 = 0;
            for (int j = 0; j < s; j++) {
                sum1 += sArr[i][j];
                sum2 += sArr[j][i];
            }
            answer = Math.max(answer, sum1);
            answer = Math.max(answer, sum2);
        }
        sum1=sum2=0;
        for (int i = 0; i < s; i++) {
            sum1 += sArr[i][i];
            sum2 += sArr[i][s-1-i];
        }
        answer = Math.max(answer, sum1);
        answer = Math.max(answer, sum2);
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int[][] sArr = new int[s][s];
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                sArr[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(s, sArr));
    }
}
