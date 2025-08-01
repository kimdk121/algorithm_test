package org.example.kimtaewon.s2.array;

import java.util.Scanner;

// 등수 구하기
public class N8 {

    public static int[] solution(int s, int[] sArr) {
        int[] answer = new int[s];
        for (int i = 0; i < s; i++) {
            int cnt = 1;
            for (int j = 0; j < s; j++) {
                if(sArr[i] < sArr[j]) {
                    cnt++;
                }
            }
            answer[i] = cnt;
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int[] sArr = new int[s];
        for (int i = 0; i < s; i++) {
            sArr[i] = sc.nextInt();
        }
        for (int i : solution(s, sArr)) {
            System.out.print(i + " ");
        }
    }
}
