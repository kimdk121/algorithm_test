package org.example.kimtaewon.s7.tree;

import java.util.LinkedList;
import java.util.Queue;

// 넓이우선탐색 레벨탐색 BFS
// 1 2 3 4 5 6 7
public class N7 {

    static class Node {
        int data;
        Node lt, rt;
        public Node(int val) {
            data = val;
            lt = rt = null;
        }
    }

    Node root;
    public void BFS(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int L=0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            System.out.print(L + " : ");
            for (int i = 0; i < len; i++) {
                Node cur = queue.poll();
                System.out.print(cur.data + " ");
                if (cur.lt != null) {
                    queue.offer(cur.lt);
                }
                if (cur.rt != null) {
                    queue.offer(cur.rt);
                }
            }
            L++;
            System.out.println();
        }
    }

    public static void main(String[] args) {
        N7 tree = new N7();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        tree.BFS(tree.root);
    }
}
