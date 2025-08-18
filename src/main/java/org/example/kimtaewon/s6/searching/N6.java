package org.example.kimtaewon.s6.searching;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// 장난꾸러기
public class N6 {

    public static List<Integer> solution(int n, int[] nArr) {
        List<Integer> answer = new ArrayList<>();
        int[] tmp = nArr.clone();
        Arrays.sort(tmp);
        for (int i = 0; i < n; i++) {
            if (nArr[i] != tmp[i]) {
                answer.add(i);
            }
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
        for (int i : solution(n, nArr)) {
            System.out.print(i+1 + " ");
        }
    }
}
