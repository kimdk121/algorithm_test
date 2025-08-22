package org.example.kimtaewon.s8.dfs;

import java.util.Scanner;

// 합이 같은 부분집합
public class N1 {

    static String answer = "NO";
    static int n, total = 0;
    static boolean flag = false;
    static int[] arr;

    public static void DFS(int L, int sum) {
        if (flag) return;
        if (sum > total/2) return;
        if (L==n) {
            if (total-sum == sum) {
                answer = "YES";
                flag = true;
            }
        } else {
            DFS(L+1, sum+arr[L]);
            DFS(L+1, sum);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            total+=arr[i];
        }
        DFS(0, 0);
        System.out.println(answer);
    }
}
