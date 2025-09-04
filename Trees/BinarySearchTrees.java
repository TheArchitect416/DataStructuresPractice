package DataStructures.Trees;

import javax.xml.stream.XMLInputFactory;

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
        } else {
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
        } else if (key < root.data) {
            return searchRec(root.left, key);
        } else {
            return searchRec(root.right, key);
        }
    }

    void inDFS(Node root) {
        if(root == null) return;
        inDFS(root.left);
        System.out.print(root.data + " ");
        inDFS(root.right);
    }

    void removeKey(int key) {
        root = removeRec(root, key);
        System.out.println("Key " + key + " removed from the BST (if it existed)");
    }

    // Note -> for any node with 2 children, we can either replace it with its inorder predecessor or inorder successor.
    // Here, we are replacing it with its inorder successor (smallest in the right subtree!)
    private Node removeRec(Node root, int key) {
        if(root == null) {
            return root;
        }
        if(key < root.data) {
            root.left = removeRec(root.left, key);
        } else if(key > root.data) {
            root.right = removeRec(root.right, key);
        } else {
            // Node with the key found
            // Node with only one child or no child
            if(root.left == null) {
                return root.right;
            } else if(root.right == null) {
                return root.left;
            }

            // Node with two children: Get the inorder successor (smallest in the right subtree)
            root.data = findInorderSuccessor(root.right);
            root.right = removeRec(root.right, root.data);
        }
        return root;
    }

    private int findInorderSuccessor(Node root) {
        int val = root.data;
        while(root.left!=null) {
            val = root.left.data;
            root = root.left;
        }
        return val;
    }
}


class Drivercode {
    public static void main(String[] args) {
        BinarySearchTrees bst = new BinarySearchTrees();

        System.out.println("Inserting keys into BST\n");
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

        System.out.println("BST Inorder DFS:");
        bst.inDFS(bst.root);
        System.out.println("\n");

        System.out.println("Searching in BST:");
        System.out.println("Searching for 50: " + bst.searchBST(50));
        System.out.println("Searching for 200: " + bst.searchBST(200));
        System.out.println("\n");
        System.out.println("Deleting keys from BST:");

        bst.removeKey(130);
        bst.removeKey(25);

        System.out.println("\n");
        System.out.println("BST Inorder DFS after deletions:");
        bst.inDFS(bst.root);
        System.out.println("\n");
        System.out.println("Searching for 25: " + bst.searchBST(25));
        System.out.println("Searching for 75: " + bst.searchBST(75));
    }
}
