package org.example.kimtaewon.s2.array;

import java.util.Scanner;

// 임시반장 정하기
public class N11 {

    public static int solution(int s, int[][] sArr) {
        int answer = 0;
        int max = 0;

        for (int i = 1; i < s+1; i++) {
            int cnt = 0;
            for (int j = 1; j < s+1; j++) {
                for (int k = 1; k < 6; k++) {
                    if(sArr[i][k] == sArr[j][k]) {
                        cnt++;
                        break;
                    }
                }
            }
            if (cnt > max) {
                max = cnt;
                answer = i;
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int[][] sArr = new int[s+1][6];
        for (int i = 1; i < s+1; i++) {
            for (int j = 1; j < 6; j++) {
                sArr[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(s, sArr));
    }
}
