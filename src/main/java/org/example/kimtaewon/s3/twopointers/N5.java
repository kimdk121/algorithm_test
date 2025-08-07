package org.example.kimtaewon.s3.twopointers;

import java.util.Scanner;

// 연속된 자연수의 합
public class N5 {

    public static int solution(int n) {
        int answer = 0;
        int sum = 0;
        int start = 1;
        for (int end = 1; end <= n; end++) {
            sum += end;
            while (sum > n) {
                sum -= start;
                start++;
            }
            if (sum == n) {
                answer++;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }
}
