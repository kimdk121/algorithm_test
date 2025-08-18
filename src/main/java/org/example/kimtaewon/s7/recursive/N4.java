package org.example.kimtaewon.s7.recursive;

// 피보나치 수열
public class N4 {

    public static int[] fibo;

    public static int DFS(int i) {
        if (fibo[i] > 0) return fibo[i];
        if (i == 1) return fibo[i] = 1;
        else if (i == 2) {
            return fibo[i] = 1;
        } else {
            return fibo[i] = DFS(i-1) + DFS(i-2);
        }

    }
    public static void main(String[] args) {
        int n = 45;
        fibo = new int[n+1];
        System.out.println(DFS(n));
        for (int i = 1; i <= n; i++) {
            System.out.print(DFS(i)+ " ");
        }
        System.out.println();
        System.out.println(fibo[n]);
    }
}

// 피보나치 수열 = 1 + 1 + 2 + 3 + 5 + 8 + 13 + 21