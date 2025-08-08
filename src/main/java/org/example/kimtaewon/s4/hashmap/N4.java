package org.example.kimtaewon.s4.hashmap;

import java.util.HashMap;
import java.util.Scanner;

// 모든 아나그램 찾기
public class N4 {

    public static int solution(String str1, String str2) {
        int answer = 0;
        int n = str1.length();
        int m = str2.length();
        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (char c : str2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) +1);
        }
        for (int i = 0; i < m -1; i++) {
            char c = str1.charAt(i);
            map1.put(c, map1.getOrDefault(c, 0) +1);
        }
        for (int i = m-1; i < n; i++) {
            char rightC = str1.charAt(i);
            map1.put(rightC, map1.getOrDefault(rightC,0) +1);
            if(map1.equals(map2)) {
                answer++;
            }
            char leftC = str1.charAt(i-(m-1));
            map1.put(leftC, map1.get(leftC) -1);
            if(map1.get(leftC) == 0) {
                map1.remove(leftC);
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.next();
        String str2 = sc.next();
        System.out.println(solution(str1, str2));
    }
}
