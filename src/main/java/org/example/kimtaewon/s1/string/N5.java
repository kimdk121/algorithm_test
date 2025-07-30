package org.example.kimtaewon.s1.string;

import java.util.*;
// 특정 문자 뒤집기
public class N5 {

    public static String solution(String str) {
        String answer = "";
        char[] charArr = str.toCharArray();
        int lt = 0;
        int rt = charArr.length-1;
        while (lt < rt) {
            if (!Character.isAlphabetic(charArr[lt])) {
                lt++;
            } else if (!Character.isAlphabetic(charArr[rt])) {
                rt--;
            }
            else {
                char tmp = charArr[lt];
                charArr[lt] = charArr[rt];
                charArr[rt] = tmp;
                lt++;
                rt--;
            }
        }
        answer = String.valueOf(charArr);
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(solution(str));
    }
}
