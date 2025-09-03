package DataStructures.Queues;

public class Queues {
    int [] arr;
    int front;
    int back;
    int size;

    Queues(int size) {
        this.size = size;
        arr = new int[size];
        front = -1;
        back = -1;
    }

    void push(int val) {
        if(back>size-1) {
            System.out.println("Tried pushing :" + val + ". queue overflown");
            return;
        }
        if(front==-1) {
            front++;
        }
        back++;
        arr[back] = val;
    }

    void pop() {
        if(front==-1 || front>back) {
            System.out.println("Tried Popping, Underflown.");
            return;
        }
        System.out.println("Popped : " + arr[back]);
        back--;
    }

    int peek() {
        if(front == -1 || front>back) {
            System.out.println("Tried Peeking, Underflown.");
            return -1;
        }
        return arr[front];
    }
    boolean isEmpty() {
        return front==-1 || front>back;
    }
}

class Drivercode {
    public static void main(String[] args) {
        Queues qu = new Queues(5);
        qu.push(1);
        qu.push(2);
    }
}