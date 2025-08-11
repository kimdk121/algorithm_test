package org.example.kimtaewon.s5.stack;

import java.util.Scanner;
import java.util.Stack;

// 크레인 인형뽑기
public class N3 {

    public static int solution(int n, int m, int[][] nArr, int[] mArr) {
        int answer = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i : mArr) {
            int col = i-1;
            for (int row = 0; row < n; row++) {
                // 뽑기
                if(nArr[row][col] == 0) continue;
                // 스택 맨 위랑 비교 stack.peek() 사용
                if (!stack.isEmpty() && stack.peek() == nArr[row][col]) {
                    answer+=2;
                    stack.pop();
                } else {
                    // stack에 넣기
                    stack.push(nArr[row][col]);
                }
                nArr[row][col] = 0;
                break;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] nArr = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                nArr[i][j] = sc.nextInt();
            }
        }
        int m = sc.nextInt();
        int[] mArr = new int[m];
        for (int i = 0; i < m; i++) {
            mArr[i] = sc.nextInt();
        }
        System.out.println(solution(n, m, nArr, mArr));
    }
}
