package org.example.kimtaewon.s6.searching;

import java.util.Arrays;
import java.util.Scanner;

// 뮤직비디오 (결정알고리즘)
public class N9 {

    public static int count(int[] arr, int capacity) {
        int cnt = 1;
        int sum = 0;
        for (int i : arr) {
            if (sum + i > capacity) {
                cnt++;
                sum = i;
            }
            else {
                sum += i;
            }
        }
        return cnt;
    }

    public static int solution(int n, int m, int[] nArr) {
        int answer = 0;
        int lt = Arrays.stream(nArr).max().getAsInt();
        int rt = Arrays.stream(nArr).sum();
        while (lt<=rt) {
            int mid = (lt + rt)/2;
            if (count(nArr, mid) <= m) {
                answer = mid;
                rt = mid-1;
            } else {
                lt = mid+1;
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
