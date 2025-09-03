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

    public static void main(String[] args) {
        BinaryTrees bt = new BinaryTrees();
        Node root = bt.createNode(20);

        root.left = bt.createNode(2);
        root.right = bt.createNode(25);
    }
}