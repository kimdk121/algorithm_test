package org.example.kimtaewon.s2.array;

import java.util.ArrayList;
import java.util.Scanner;

// 가위바위보
public class N3 {

    public static ArrayList<String> solution(int s, int[] sArr1, int[] sArr2) {
        ArrayList<String> answer = new ArrayList<>();
        for (int i = 0; i < s; i++) {
            if(sArr1[i] == sArr2[i]) {
                answer.add("D");
            } else if (sArr1[i] == 1 && sArr2[i] == 3) {
                answer.add("A");
            } else if (sArr1[i] == 2 && sArr2[i] == 1) {
                answer.add("A");
            } else if (sArr1[i] == 3 && sArr2[i] == 2) {
                answer.add("A");
            } else {
                answer.add("B");
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int[] sArr1 = new int[s];
        int[] sArr2 = new int[s];
        for (int i = 0; i < s; i++) {
            sArr1[i] = sc.nextInt();
        }
        for (int i = 0; i < s; i++) {
            sArr2[i] = sc.nextInt();
        }
        for(String a : solution(s, sArr1, sArr2)) {
            System.out.println(a);
        }
    }
}
