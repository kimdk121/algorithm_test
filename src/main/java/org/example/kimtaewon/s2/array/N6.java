package org.example.kimtaewon.s2.array;

import java.util.ArrayList;
import java.util.Scanner;

// 뒤집은 소수
public class N6 {

    public static ArrayList<Integer> solution(int s, String[] sArr) {
        ArrayList<Integer> answer = new ArrayList<>();
        int[] intArr = new int[s];
        for (int i = 0; i < s; i++) {
            StringBuilder stringBuilder = new StringBuilder(sArr[i]);
            intArr[i] = Integer.parseInt(stringBuilder.reverse().toString());
        }
        for (int i = 0; i < s; i++) {
            if (intArr[i] < 2) continue;
            if (checkPrime(intArr[i])) {
                answer.add(intArr[i]);
            }
        }
        return answer;
    }

    public static boolean checkPrime(int s) {
        for (int i = 2; i * i <= s; i++) {
            if (s % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        String[] sArr = new String[s];
        for (int i = 0; i < s; i++) {
            sArr[i] = sc.next();
        }
        for (int i : solution(s, sArr)) {
            System.out.print(i + " ");
        }
    }
}
