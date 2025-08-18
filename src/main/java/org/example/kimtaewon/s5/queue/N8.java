package org.example.kimtaewon.s5.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

// 응급실
public class N8 {

    private static class patient {
        int id;
        int risk;

        patient(int id, int risk) {
            this.id = id;
            this.risk = risk;
        }
    }

    private static int solution(int n, int m, int[] nArr) {
        int answer = 0;
        Queue<patient> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.offer(new patient(i, nArr[i]));
        }
        while (!queue.isEmpty()) {
            patient patient = queue.poll();
            boolean hasHigher = false;
            for (patient other : queue) {
                if(patient.risk < other.risk) {
                    hasHigher = true;
                    break;
                }
            }
            if (hasHigher) {
                queue.offer(patient);
            } else {
                answer++;
                if (patient.id == m) {
                    return answer;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] nArr = new int[n];
        for (int i = 0; i < n; i++) {
            nArr[i] = sc.nextInt();
        }
        System.out.println(solution(n, m, nArr));
    }
}
