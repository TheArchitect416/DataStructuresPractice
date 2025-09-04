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

public class BinarySearchTrees {
    Node root;

    BinarySearchTrees() {
        root = null;
    }

    void insertKey(int key) {
        root = insertRec(root, key);
    }

    private Node insertRec(Node root, int key) {
        if (root == null) {
            return new Node(key);
        }
        if (key < root.data) {
            root.left = insertRec(root.left, key);
        } else if (key > root.data) {
            root.right = insertRec(root.right, key);
        } else if (key == root.data) {
            throw new RuntimeException("Duplicate keys are not allowed in BST");
        }
        return root;
    }

    boolean searchBST(int key) {
            return searchRec(root, key);
    }

    private boolean searchRec(Node root, int key) {
        if(root == null) {
            return false;
        }
        if(root.data == key) {
            return true;
        }
        if(key < root.data) {
            return searchRec(root.left, key);
        } else {
            return searchRec(root.right, key);
        }
    }

    void removeKey() {

    }
}


class Drivercode {
    public static void main(String[] args) {
        BinarySearchTrees bst = new BinarySearchTrees();

        bst.insertKey(100);
        bst.insertKey(50);
        bst.insertKey(150);
        bst.insertKey(25);
        bst.insertKey(75);
        bst.insertKey(125);
        bst.insertKey(175);
        bst.insertKey(10);
        bst.insertKey(30);
        bst.insertKey(60);
        bst.insertKey(80);
        bst.insertKey(110);
        bst.insertKey(130);

        System.out.println(bst.searchBST(50));
        System.out.println(bst.searchBST(200));
    }
}
