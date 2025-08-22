package org.example.kimtaewon.s7.tree;

import java.util.LinkedList;
import java.util.Queue;

// Tree 말단노드까지의 가장 짧은 경로 (BFS 활용)
public class N10 {

    static class Node {
        int data;
        Node lt, rt;
        public Node(int val) {
            data = val;
            lt = rt = null;
        }
    }

    Node root;

    public int BFS(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        int L = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node cur = queue.poll();
                if (cur.lt == null && cur.rt == null) {
                    return L;
                }
                if (cur.lt != null) queue.offer(cur.lt);
                if (cur.rt != null) queue.offer(cur.rt);
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) {
        N10 tree = new N10();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        System.out.println(tree.BFS(tree.root));
    }
}
