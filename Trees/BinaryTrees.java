package DataStructures.Trees;

import java.util.Queue;
import java.util.LinkedList;

//class Node {
//    Node left;
//    Node right;
//    int data;
//
//    Node(int data) {
//        this.data = data;
//        left = null;
//        right = null;
//    }
//}

public class BinaryTrees {
    Node createNode(int val) {
        return new Node(val);
    }

    static void preDFS(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        preDFS(root.left);
        preDFS(root.right);
    }

    static void inDFS(Node root) {
        if(root == null) {
            return;
        }
        inDFS(root.left);
        System.out.print(root.data + " ");
        inDFS(root.right);
    }

    static void postDFS(Node root) {
        if(root == null) {
            return;
        }
        postDFS(root.left);
        postDFS(root.right);
        System.out.print(root.data + " ");
    }

    static void bfs(Node root) {
        Queue<Node> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            Node curr = q.poll();
            System.out.print(curr.data + " ");
            if (curr.left != null) {
                q.offer(curr.left);
            }
            if (curr.right != null) {
                q.offer(curr.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTrees bt = new BinaryTrees();
        Node root = bt.createNode(1);

        root.left = bt.createNode(2);
        root.right = bt.createNode(3);

        root.left.left = bt.createNode(4);
        root.left.right = bt.createNode(5);
        root.right.left = bt.createNode(6);
        root.right.right = bt.createNode(7);

        root.left.right.left = bt.createNode(8);
        root.right.left.left = bt.createNode(15);
        root.right.left.right = bt.createNode(9);

        System.out.print("\nPre-order : ");
        bt.preDFS(root);
        System.out.print("\nIn-order : ");
        bt.inDFS(root);
        System.out.print("\nPost-order : ");
        bt.postDFS(root);

        System.out.print("\nBFS : ");
        bt.bfs(root);
    }
}