package org.example.kimtaewon.s10.dynamicprogramming;

import java.util.Scanner;

// 최대부분증가수열
public class N3 {

    public static int solution(int n, int[] arr, int[] dy) {
        int answer = 0;
        dy[0] = 1;
        for (int i = 1; i < n; i++) {
            int max = 0;
            for (int j = i-1; j >= 0; j--) {
                if (arr[j] < arr[i] && dy[j] > max) {
                    max = dy[j];
                }
            }
            dy[i] = max + 1;
            answer = Math.max(answer, dy[i]);
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] dy = new int[n];
        System.out.println(solution(n, arr, dy));
    }
}
