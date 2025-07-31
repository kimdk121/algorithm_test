package org.example.kimtaewon.s2.array;

import java.util.Scanner;

// 보이는 학생
public class N2 {

    public static int solution(int s, int[] sArr) {
        int answer = 0;
        int max =0;
        for (int i=0; i<s; i++) {
            if(sArr[i] > max) {
                answer++;
                max = sArr[i];
            }
        }
        return answer;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int[] sArr = new int[s];
        for (int i=0; i<s; i++) {
            sArr[i] = sc.nextInt();
        }
        System.out.println(solution(s, sArr));
    }
}
