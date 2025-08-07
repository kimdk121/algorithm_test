package org.example.kimtaewon.s3.twopointers;

import java.util.Scanner;

// 연속 부분수열
public class N4 {

    public static int solution(int n, int m, int[] nArr) {
        int answer = 0;
        int start = 0;
        int sum = 0;
        for (int end = 0; end < n; end++) {
            sum += nArr[end];
            while (sum > m) {
                sum -= nArr[start];
                start++;
            }
            if (sum == m) {
                answer++;
            }
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
