package DataStructures.LinkedList.Doubly;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

public class DLL {
    Node head;

    DLL() {
        this.head = null;
    }

    public void insertAtHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        if (head != null) {
            head.prev = newNode;
        }
        head = newNode;
    }

    public void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    public int getSizeLL() {
        int size = 0;
        Node temp = head;
        while (temp != null) {
            temp = temp.next;
            size++;
        }
        return size;
    }

    public void insertAtPos(int data, int pos) {
        if (pos < 1) {
            System.out.println("Invalid position");
            return;
        }
        if (pos == 1) {
            insertAtHead(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        for (int i = 1; i < pos - 1; i++) {
            if (temp == null) {
                System.out.println("Invalid position");
                return;
            }
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Invalid position");
            return;
        }
        newNode.next = temp.next;
        if (temp.next != null) {
            temp.next.prev = newNode;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    public void deleteAtHead() {
        if (head == null) {
            return;
        }
        if (head.next != null) {
            head.next.prev = null;
        }
        head = head.next;
    }

    public void deleteAtEnd() {
        if (head == null) {
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.prev.next = null;
    }

    public void deleteByValue(int data) {
        if (head == null) {
            return;
        }
        if (head.data == data) {
            deleteAtHead();
            return;
        }
        Node temp = head;
        while (temp != null && temp.data != data) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Value not found");
            return;
        }
        if (temp.next != null) {
            temp.next.prev = temp.prev;
        }
        if (temp.prev != null) {
            temp.prev.next = temp.next;
        }
    }

    public void printLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public void printLLReverse() {
        Node temp = head;
        if (temp == null) {
            return;
        }
        while (temp.next != null) {
            temp = temp.next;
        }
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.prev;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        DLL dll = new DLL();
        dll.insertAtHead(10);
        dll.insertAtHead(20);
        dll.insertAtHead(30);
        dll.printLL();
        dll.insertAtEnd(40);
        dll.printLL();
        dll.printLLReverse();
        dll.insertAtPos(50, 3);
        dll.printLL();
        dll.deleteAtHead();
        dll.printLL();
        dll.deleteAtEnd();
        dll.printLL();
        dll.deleteByValue(10);
        dll.printLL();
    }
}