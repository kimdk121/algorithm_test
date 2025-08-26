package org.example.kimtaewon.s9.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 씨름 선수
public class N1 {

    static class Body implements Comparable<Body> {
        int h;
        int w;
        Body(int h, int w) {
            this.h = h;
            this.w = w;
        }

        @Override
        public int compareTo(Body o) {
            return o.h - this.h;
        }
    }

    public static int solution(ArrayList<Body> arr, int n) {
        int answer = 0;
        Collections.sort(arr);
        int max = 0;
        for (Body body : arr) {
            if (body.w > max) {
                max = body.w;
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Body> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            arr.add(new Body(sc.nextInt(), sc.nextInt()));
        }
        System.out.println(solution(arr, n));
    }
}
