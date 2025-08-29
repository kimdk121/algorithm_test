package org.example.kimtaewon.s10.dynamicprogramming;

import java.util.Scanner;

// 돌다리 건너기
public class N2 {

    public static int solution(int n, int[] dy) {
        int answer = 0;
        dy[1] = 1;
        dy[2] = 2;
        for (int i = 3; i <= n+1; i++) {
            dy[i] = dy[i-2] + dy[i-1];
        }
        answer = dy[n+1];
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] dy = new int[n+2];
        System.out.println(solution(n, dy));
    }
}
