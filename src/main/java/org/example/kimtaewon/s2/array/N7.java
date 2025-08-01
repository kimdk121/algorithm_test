package org.example.kimtaewon.s2.array;

import java.util.Scanner;

// 점수계산
public class N7 {

    public static int solution(int s, int[] sArr) {
        int answer = 0;
        int cnt = 0;
        for (int i = 0; i < s; i++) {
            if (sArr[i] == 0) {
                cnt = 0;
            } else {
                cnt++;
                answer += cnt;
            }
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
        System.out.println(solution(s, sArr));
    }
}
