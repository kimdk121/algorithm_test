package org.example.kimtaewon.s10.dynamicprogramming;

import java.util.Scanner;

// 계단 오르기
public class N1 {

    static int[] dy;
    static int n;

    public static int solution() {
        int answer = 0;
        dy[1] = 1;
        dy[2] = 2;
        for (int i = 3; i <= n; i++) {
            dy[i] = dy[i-2] + dy[i-1];
        }
        answer = dy[n];
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        dy = new int[n+1];
        System.out.println(solution());
    }
}
