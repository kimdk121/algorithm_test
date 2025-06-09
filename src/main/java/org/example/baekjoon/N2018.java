package org.example.baekjoon;
import java.util.Scanner;

// 투포인터 연속된 자연수의 합 구하기
public class N2018 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int count = 1;
        int startIdx = 1;
        int endIdx = 1;
        int sum = 1;
        while(endIdx != N) {
            if(sum == N) {
                count++;
                endIdx++;
                sum = sum + endIdx;
            }
            else if(sum < N) {
                endIdx++;
                sum = sum + endIdx;
            }
            else {
                sum = sum - startIdx;
                startIdx++;
            }
        }
        System.out.println(count);
    }
}
