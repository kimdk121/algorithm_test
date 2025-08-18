package org.example.kimtaewon.s7.recursive;

// 이진수 출력
public class N2 {

    public static void DFS(int n) {
        if (n==0) return;
        else {
            DFS(n/2);
            System.out.print(n % 2 + " ");
        }
    }

    public static void main(String[] args) {
        DFS(11);
    }
}