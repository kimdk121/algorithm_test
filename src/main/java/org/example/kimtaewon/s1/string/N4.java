package org.example.kimtaewon.s1.string;

import java.util.ArrayList;
import java.util.Scanner;

// 단어 뒤집기
public class N4 {

    public static ArrayList<String> solution(int max, String[] arr) {
        ArrayList<String> answer = new ArrayList<String>();
        for (String str : arr) {
            char[] charArr = str.toCharArray();
            int lt = 0;
            int rt = charArr.length-1;
            while (lt < rt) {
                char tmp = charArr[lt];
                charArr[lt] = charArr[rt];
                charArr[rt] = tmp;
                lt++;
                rt--;
            }
            answer.add(String.valueOf(charArr));
        }
        return answer;
    }
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int max = sc.nextInt();
        String[] arr = new String[max];
        for(int i=0; i<max; i++) {
            arr[i] = sc.next();
        }
        for (String answer : solution(max, arr)) {
            System.out.println(answer);
        }
    }
}
