package org.example.kimtaewon.s9.greedy;

import java.util.*;

// 최대수입스케쥴
public class N4 {

    static class Lecture implements Comparable<Lecture>{
        int pay;
        int day;
        Lecture(int pay, int day) {
            this.pay = pay;
            this.day = day;
        }

        @Override
        public int compareTo(Lecture o) {
            return o.day - this.day;
        }
    }

    public static int solution(int n, ArrayList<Lecture> lectures, int maxDay) {
        int answer = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Collections.sort(lectures);
        int j = 0;
        for (int i = maxDay; i >= 1; i--) {
            for (; j < lectures.size(); j++) {
                if (lectures.get(j).day < i) {
                    break;
                } else {
                    pq.offer(lectures.get(j).pay);
                }
            }
            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Lecture> lectures = new ArrayList<>();
        int maxDay = 0;
        for (int i = 0; i < n; i++) {
            int pay = sc.nextInt();
            int day = sc.nextInt();
            lectures.add(new Lecture(pay, day));
            if (day > maxDay) {
                maxDay = day;
            }
        }
        System.out.println(solution(n, lectures, maxDay));
    }
}
