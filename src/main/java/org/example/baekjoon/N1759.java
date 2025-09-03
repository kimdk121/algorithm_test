package org.example.baekjoon;

import java.util.Arrays;
import java.util.Scanner;

// 암호 만들기 (DFS)
public class N1759 {

    static int n, m;
    static char[] arr;
    static int[] ch;
    static char[] vowelArr = {'a', 'e', 'i', 'o', 'u'};

    public static boolean isVowel(char c) {
        for (char vowel : vowelArr) {
            if (c == vowel) {
                return true;
            }
        }
        return false;
    }

    public static void DFS(int L, int len, StringBuilder password, int consonantCnt, int vowelCnt) {
        if (len == n) {
            if (consonantCnt >= 2 && vowelCnt >= 1) {
                System.out.println(password);
            }
        } else {
            for (int i = L; i < m; i++) {
                if (ch[i] == 0) {
                    ch[i] = 1;
                    char c = arr[i];
                    if (isVowel(c)) {
                        DFS(i+1, len+1, password.append(c), consonantCnt, vowelCnt+1);
                    } else {
                        DFS(i+1,len+1, password.append(c), consonantCnt+1, vowelCnt);
                    }
                    password.deleteCharAt(password.length()-1);
                    ch[i] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        m = sc.nextInt();
        arr = new char[m];
        ch = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = sc.next().charAt(0);
        }
        Arrays.sort(arr);
        DFS(0, 0, new StringBuilder(),0, 0);
    }
}
