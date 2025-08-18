package org.example.kimtaewon.s3.slidingwindow;

import java.util.Scanner;

// 최대 매출
public class N3 {

    public static int solution(int n, int m, int[] nArr) {
        int answer = 0;
        int sum = 0;
        for (int i = 0; i < m; i++) {
            sum += nArr[i];
        }
        answer = sum;
        for (int i = m; i < n; i++) {
            sum += nArr[i];
            sum -= nArr[i-m];
            answer = Math.max(answer, sum);
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nArr = new int[n];
        for (int i = 0; i < n; i++) {
            nArr[i] = sc.nextInt();
        }
        System.out.println(solution(n, m, nArr));
    }
}
