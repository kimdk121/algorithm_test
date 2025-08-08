package org.example.kimtaewon.s4.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

// 매출액의 종류
public class N3 {

    public static List<Integer> solution(int n, int m, int[] nArr) {
        List<Integer> answer = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < m-1; i++) {
            map.put(nArr[i], map.getOrDefault(nArr[i], 0)+1);
        }

        for (int i = m-1; i < n; i++) {
            map.put(nArr[i], map.getOrDefault(nArr[i], 0) +1);
            answer.add(map.size());

            int leftKey = nArr[i-(m-1)];
            int leftValue = map.get(leftKey);
            if(leftValue == 1) {
                map.remove(leftKey);
            } else {
                map.put(leftKey, leftValue -1);
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
        for(int i : solution(n, m, nArr)) {
            System.out.print(i + " ");
        }
    }
}
