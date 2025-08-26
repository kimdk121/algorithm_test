package org.example.kimtaewon.s9.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 결혼식
public class N3 {

    static class Time implements Comparable<Time>{
        int time;
        char state;
        Time(int time, char state) {
            this.time = time;
            this.state = state;
        }

        @Override
        public int compareTo(Time o) {
            if (this.time == o.time) return o.state - this.state;
            return this.time - o.time;
        }
    }

    public static int solution(int n, ArrayList<Time> times) {
        int answer = 0;
        int cnt = 0;
        Collections.sort(times);
        for (Time time : times) {
            if (time.state == 'o') {
                cnt--;
            } else {
                cnt++;
                answer = Math.max(answer, cnt);
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Time> times = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            times.add(new Time(sc.nextInt(), 'i'));
            times.add(new Time(sc.nextInt(), 'o'));
        }
        System.out.println(solution(n, times));
    }
}
