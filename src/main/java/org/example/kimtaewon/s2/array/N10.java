package org.example.kimtaewon.s2.array;

import java.util.Scanner;

// 봉우리 개수 구하기
public class N10 {

    public static int solution(int s, int[][] sArr) {
        int answer = 0;
        for (int i = 0; i < s; i++) {
            for (int j = 0; j < s; j++) {
                //상
                boolean top = i == 0 || sArr[i][j] > sArr[i-1][j];
                boolean bottom = i == s-1 || sArr[i][j] > sArr[i+1][j];
                boolean left = j == 0 || sArr[i][j] > sArr[i][j-1];
                boolean right = j == s-1 || sArr[i][j] > sArr[i][j+1];

                if (top && bottom && left && right) {
                    answer++;
                }
            }
        }
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
