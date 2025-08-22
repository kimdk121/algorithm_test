package org.example.kimtaewon.s7.tree;

// Tree 말단노드까지의 가장 짧은 경로 (DFS 활용)
public class N9 {

    static class Node {
        int data;
        Node lt, rt;
        public Node(int val) {
            data = val;
            lt = rt = null;
        }
    }

    Node root;

    public int DFS(int L, Node root) {
        if (root.lt == null && root.rt == null) {
            return L;
        } else {
            return Math.min(DFS(L+1, root.lt), DFS(L+1, root.rt));
        }
    }

    public static void main(String[] args) {
        N9 tree = new N9();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.DFS(0, tree.root);
    }
}
