package org.example.kimtaewon.s7.tree;

// 이진트리순회
public class N5 {

    static class Node {
        int data;
        Node lt, rt;
        public Node(int val) {
            data = val;
            lt = rt = null;
        }
    }

    Node root;
    public static void DFS(Node root) {
        if (root == null) return;
        else {
            // 전위 순회
            // System.out.print(root.data + " ");
            DFS(root.lt);
            // 중위 순회
            // System.out.print(root.data + " ");
            DFS(root.rt);
            // 후위 순회
            // System.out.print(root.data + " ");
        }
    }

    public static void main(String[] args) {
        N5 tree = new N5();
        tree.root = new Node(1);
        tree.root.lt = new Node(2);
        tree.root.rt = new Node(3);
        tree.root.lt.lt = new Node(4);
        tree.root.lt.rt = new Node(5);
        tree.root.rt.lt = new Node(6);
        tree.root.rt.rt = new Node(7);
        DFS(tree.root);
    }
}
