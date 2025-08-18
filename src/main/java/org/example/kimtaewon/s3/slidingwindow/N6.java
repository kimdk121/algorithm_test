package org.example.kimtaewon.s3.slidingwindow;

import java.util.Scanner;

// 최대 길이 연속 부분 수열
public class N6 {

    public static int solution(int n, int m, int[] nArr) {
        int answer = 0;
        int limit = 0;
        int lt = 0;
        for (int rt = 0; rt < n; rt++) {
            if (nArr[rt] == 0) {
                limit++;
            }
            while (limit > m) {
                if (nArr[lt] == 0) {
                    limit--;
                }
                lt++;
            }
            answer = Math.max(answer, rt - lt +1);
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
// 기본 프로세스
// rt올림 -> 0 인지 1 인지 확인 -> 0이면 리미트 올리고 1이면 sum 올림 -> 리미트가 m이랑 같으면 answer에 sum 이랑 비교해서 올림 -> lt 0까지 이동 -> 리미트 1 빼기
