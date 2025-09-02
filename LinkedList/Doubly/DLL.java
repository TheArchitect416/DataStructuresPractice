package DataStructures.LinkedList.Doubly;

class Node {
    Integer data;
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
        head = null;
    }

    void insertAtHead(int val) {
        Node n = new Node(val);
        if(head != null) {
            head.prev = n;
        }
        n.next = head;
        head = n;
    }

    void insertAtEnd(int val) {
        Node tail = new Node(val);
        if (head == null) {
            head = tail;
            return;
        }
        Node temp = head;
        while (temp.next != null) temp = temp.next;
        temp.next = tail;
    }

    int getSizeLL() {
        int size = 0;
        Node temp = head;
        while(temp!=null) {
            temp=temp.next;
            size++;
        }
        return size;
    }

    void insertException(int val, int pos) {
        Node n = new Node(val);
        int sizeLL = getSizeLL();
        if(pos<0 || pos>sizeLL) {
            System.out.println("Invalid Size");
        } else if(pos==0) {
            n.next = head;
            head = n;
        } else {
            Node temp = head;
            while(--pos != 0) {
                temp = temp.next;
            }
            n.next = temp.next;
            temp.next = n;
        }
    }

    void insertAtPos(int val, int pos) {

        if (pos <= 1) {
            Node n = new Node(val);
            n.next = head;
            head = n;
            return;
        }

        if (head == null) {
            head = new Node(null);
        }

        Node curr = head;
        int i = 1;

        while (i < pos - 1) {
            if (curr.next == null) {
                curr.next = new Node(null);
            }
            curr = curr.next;
            i++;
        }

        Node n = new Node(val);
        n.next = curr.next;
        curr.next = n;
    }

    void deleteAtHead() {
        if(head==null) {
            System.out.print("Linked List Empty");
            return;
        }
        Node temp = head;
        head = head.next;
        temp = null;
        System.out.print("Head Node deleted\n");
    }

    void deleteByValue(int val) {
        if(head == null) {
            System.out.println("Linked List Empty");
            return;
        }
        if(head.data==val) {
            deleteAtHead();
            return;
        }
        Node temp = head;
        while(temp.next!=null && temp.next.data!=val) {
            temp = temp.next;
        }
        if(temp.next==null) {
            System.out.println("Value not found");
            return;
        }
        Node toDelete = temp.next;
        temp.next = temp.next.next;
        toDelete = null;
    }

    void printLL() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + "->");
            temp = temp.next;
        }
        System.out.print("NULL\n");
    }
}

class Drivercode {
    public static void main(String[] args) {
        DLL dll = new DLL();
        dll.insertAtHead(10);
        dll.insertAtHead(20);
        dll.insertAtHead(70);
        dll.printLL();
        dll.insertAtEnd(50);
        dll.insertAtEnd(60);
        dll.printLL();
        dll.insertAtPos(90, 9);
        dll.insertAtPos(40, 4);
        dll.printLL();
        dll.insertAtPos(30, 3);
        dll.insertAtPos(5, -3);
        dll.printLL();
        dll.insertAtPos(3, 1);
        dll.printLL();
        dll.insertException(999,90);
        dll.insertException(1000,-999);

        dll.deleteAtHead();
        dll.deleteByValue(60);
        dll.printLL();
        dll.deleteByValue(97);
    }
