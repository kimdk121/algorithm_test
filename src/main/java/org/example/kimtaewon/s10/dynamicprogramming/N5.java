package org.example.kimtaewon.s10.dynamicprogramming;

import java.util.Arrays;
import java.util.Scanner;

// 동전교환 (냅색 알고리즘)
public class N5 {

    public static int solution(int n, int m, int[] coins, int[] dy) {
        int answer = 0;
        Arrays.fill(dy, Integer.MAX_VALUE);
        dy[0] = 0;
        for (int i = 0; i < n; i++) {
            int coin = coins[i];
            for (int j = coin; j <= m; j++) {
                dy[j] = Math.min(dy[j], dy[j - coin] + 1);
            }
        }
        answer = dy[m];
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] coins = new int[n];
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] dy = new int[m+1];
        System.out.println(solution(n, m, coins, dy));
    }
}
