package org.example.baekjoon;

import java.util.ArrayList;
import java.util.Scanner;

// 스도쿠
public class N2580 {

    static class Point {
        int x;
        int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[][] sudoku;
    static boolean[][] rows;
    static boolean[][] columns;
    static boolean[][] boxs;
    static ArrayList<Point> blanks;
    static boolean flag = false;

    public static int findBox(int y, int x) {
        return (y / 3) * 3 + (x / 3);
    }

    public static void DFS(int n) {
        if (blanks.size() == n) {
            flag = true;
            return;
        } else {
            int x = blanks.get(n).x;
            int y = blanks.get(n).y;
            for (int i = 1; i <= 9; i++) {
                if (!rows[y][i] && !columns[x][i] && !boxs[findBox(y, x)][i]) {
                    sudoku[y][x] = i;
                    rows[y][i] = columns[x][i] = boxs[findBox(y, x)][i] = true;

                    DFS(n+1);
                    if (flag) return;

                    sudoku[y][x] = 0;
                    rows[y][i] = columns[x][i] = boxs[findBox(y, x)][i] = false;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        sudoku = new int[9][9];
        rows = new boolean[9][10];
        columns = new boolean[9][10];
        boxs = new boolean[9][10];
        blanks = new ArrayList<>();

        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                int next = sc.nextInt();
                sudoku[y][x] = next;
                if (next == 0) {
                    blanks.add(new Point(x, y));
                } else {
                    rows[y][next] = true;
                    columns[x][next] = true;
                    boxs[findBox(y, x)][next] = true;
                }
            }
        }

        DFS(0);

        for (int y = 0; y < 9; y++) {
            for (int x = 0; x < 9; x++) {
                System.out.print(sudoku[y][x] + " ");
            }
            System.out.println();
        }
    }
}
