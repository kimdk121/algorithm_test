package org.example.kimtaewon.s2.array;

import java.util.ArrayList;
import java.util.Scanner;

// 큰수 출력하기
public class N1 {

    public static ArrayList<Integer> solution(int s, int[] intArr) {
        ArrayList<Integer> answer = new ArrayList<>();
        answer.add(intArr[0]);
        for (int i=1; i<s; i++) {
            if(intArr[i] > intArr[i-1]) {
                answer.add(intArr[i]);
            }
        }
        return answer;
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int[] intArr = new int[s];
        for (int i=0; i<s; i++) {
            intArr[i] = sc.nextInt();
        }
        for (int a : solution(s, intArr)) {
            System.out.print(a + " ");
        }
    }
}