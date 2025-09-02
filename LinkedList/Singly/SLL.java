package DataStructures.LinkedList.Singly;

class Node {
    Integer data;
    Node next;

    Node(Integer data) {
        this.data = data;
        this.next = null;
    }
}

public class SLL {
    Node head;

    SLL() {
        head = null;
    }

    void insertAtHead(int val) {
        Node n = new Node(val);
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
        SLL sll = new SLL();
        sll.insertAtHead(10);
        sll.insertAtHead(20);
        sll.insertAtHead(70);
        sll.printLL();
        sll.insertAtEnd(50);
        sll.insertAtEnd(60);
        sll.printLL();
        sll.insertAtPos(90, 12);
        sll.insertAtPos(40, 4);
        sll.printLL();
        sll.insertAtPos(30, 3);
        sll.insertAtPos(5, -3);
        sll.printLL();
        sll.insertAtPos(3, 1);
        sll.printLL();
        sll.insertException(999,90);
        sll.insertException(1000,-999);
    }
}