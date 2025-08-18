package org.example.kimtaewon.s6.searching;

import java.util.Arrays;
import java.util.Scanner;

// 마구간 정하기 (결정알고리즘)
public class N10 {

    public static int count(int[] nArr, int dist) {
        int cnt = 1;
        int endPos = nArr[0];
        for (int i = 1; i < nArr.length; i++) {
            if (nArr[i]-endPos >= dist) {
                cnt++;
                endPos = nArr[i];
            }
        }
        return cnt;
    }
    public static int solution(int n, int m, int[] nArr) {
        int answer = 0;
        Arrays.sort(nArr);
        int lt = 1;
        int rt = nArr[n-1];
        while (lt <= rt) {
            int mid = (lt + rt)/2;
            if (count(nArr, mid) >= m) {
                answer = mid;
                lt = mid +1;
            } else {
                rt = mid -1;
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
