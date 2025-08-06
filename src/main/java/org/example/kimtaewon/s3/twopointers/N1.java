package org.example.kimtaewon.s3.twopointers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 두 배열 합치기
public class N1 {

    public static List<Integer> solution(int n, int m, int[] nArr, int[] mArr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int p1=0, p2=0;
        while (p1 < n && p2 < m) {
            if (nArr[p1] < mArr[p2]) {
                answer.add(nArr[p1]);
                p1++;
            } else {
                answer.add(mArr[p2]);
                p2++;
            }
        }
        while (p1 < n) {
            answer.add(nArr[p1]);
            p1++;
        }
        while (p2 < m) {
            answer.add(mArr[p2]);
            p2++;
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nArr = new int[n];
        for (int i = 0; i < n; i++) {
            nArr[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] mArr = new int[m];
        for (int i = 0; i < m; i++) {
            mArr[i] = sc.nextInt();
        }
        for (int i : solution(n, m, nArr, mArr)) {
            System.out.print(i + " ");
        }
    }
}
