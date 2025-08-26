package org.example.kimtaewon.s9.greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

// 회의실 배정
public class N2 {

    static class Meeting implements Comparable<Meeting>{
        int start;
        int end;
        Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Meeting o) {
            if (this.end == o.end) return this.start - o.start;
            else return this.end - o.end;
        }
    }

    public static int solution(ArrayList<Meeting> meetings, int n) {
        int answer = 0;
        int endTime = 0;
        Collections.sort(meetings);
        for (Meeting meeting : meetings) {
            if (endTime <= meeting.start) {
                answer++;
                endTime = meeting.end;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            meetings.add(new Meeting(sc.nextInt(), sc.nextInt()));
        }
        System.out.println(solution(meetings, n));
    }
}
