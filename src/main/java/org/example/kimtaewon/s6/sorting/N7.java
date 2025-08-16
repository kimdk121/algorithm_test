package org.example.kimtaewon.s6.sorting;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class N7 {

    static class Point implements Comparable<Point> {

        public int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public int compareTo(Point o) {
            if (this.x == o.x) return this.y-o.y;
            else return this.x-o.x;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ArrayList<Point> arr = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            arr.add(new Point(x, y));
        }
        Collections.sort(arr);
        for (Point point : arr) {
            System.out.println(point.x + " " + point.y);
        }
    }
}
