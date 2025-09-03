package DataStructures.Trees;

class Node {
    Node left;
    Node right;
    int data;

    Node(int data) {
        this.data = data;
        left = null;
        right = null;
    }
}
public class BinaryTrees {
    Node createNode(int val) {
        return new Node(val);
    }

    static void PreDFS(Node root) {
        if(root == null) {
            return;
        }
        System.out.print(root.data + " ");
        PreDFS(root.left);
        PreDFS(root.right);
    }

    static void InDFS(Node root) {
        if(root == null) {
            return;
        }
        InDFS(root.left);
        System.out.print(root.data + " ");
        InDFS(root.right);
    }

    static void PostDFS(Node root) {
        if(root == null) {
            return;
        }
        PostDFS(root.left);
        PostDFS(root.right);
        System.out.print(root.data + " ");
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
        bt.PreDFS(root);
        System.out.print("\nIn-order : ");
        bt.InDFS(root);
        System.out.print("\nPost-order : ");
        bt.PostDFS(root);
    }
}








//DFS answers:
//In : 4 2 8 5 1 15 6 9 3 7
//Post : 4 8 5 2 15 9 6 7 3 1