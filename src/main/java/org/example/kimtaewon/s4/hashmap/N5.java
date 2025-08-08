package org.example.kimtaewon.s4.hashmap;

import java.util.Collections;
import java.util.Scanner;
import java.util.TreeSet;

// K번째 큰수
public class N5 {

    public static int solution(int n, int m, int[] nArr) {
        int answer = -1;
        TreeSet<Integer> treeSet = new TreeSet<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                for (int k = j+1; k < n; k++) {
                    treeSet.add(nArr[i]+nArr[j]+nArr[k]);
                }
            }
        }
        int cnt = 0;
        for (Integer i : treeSet) {
            cnt ++;
            if(cnt == m) {
                answer = i;
                break;
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
