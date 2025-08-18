package org.example.kimtaewon.s7.recursive;

// 재귀함수 , 스택프레임
public class N1 {

    public static void DFS(int n) {
        if (n==0) return;
        else {
            DFS(n-1);
            System.out.print(n + " ");
        }
    }

    public static void main(String[] args) {
        DFS(3);
    }
}
