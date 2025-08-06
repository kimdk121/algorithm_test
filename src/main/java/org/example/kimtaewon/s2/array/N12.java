package org.example.kimtaewon.s2.array;

import java.util.Scanner;

// 멘토링
public class N12 {

    public static int solution(int n, int m, int[][] sArr) {
        int answer = 0;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                boolean isMentor = true;
                for (int k = 0; k < m; k++) {
                    int pi = 0;
                    int pj = 0;
                    for (int l = 0; l < n; l++) {
                        if (sArr[k][l] == i) pi = l;
                        if (sArr[k][l] == j) pj = l;
                    }
                    if(pi >= pj) {
                        isMentor = false;
                        break;
                    }
                }
                if (isMentor) answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] sArr = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sArr[i][j] = sc.nextInt();
            }
        }
        System.out.println(solution(n, m, sArr));
    }
}
