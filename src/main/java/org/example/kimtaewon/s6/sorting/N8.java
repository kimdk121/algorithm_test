package org.example.kimtaewon.s6.sorting;

import java.util.Arrays;
import java.util.Scanner;

// 이분검색
public class N8 {

    public static int solution(int n, int m, int[] nArr) {
        int answer = 0;
        Arrays.sort(nArr);
        int lt = 0;
        int rt = n-1;
        while (lt <= rt) {
            int mid = (lt + rt) /2;
            if (nArr[mid] == m) {
                answer = mid + 1;
                break;
            } else if (nArr[mid] > m) {
                rt = mid - 1;
            } else {
                lt = mid + 1;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nArr = new int[n];
        for (int i = 0; i < n; i++) {
            nArr[i] = sc.nextInt();
        }
        System.out.println(solution(n, m, nArr));
    }
}
