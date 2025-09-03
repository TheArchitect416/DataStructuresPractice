package DataStructures.Stacks;

public class Stacks {
    int size;
    int [] arr;
    int top;

    Stacks(int size) {
        this.size = size;
        arr = new int[size];
        top = -1;
    }

    void push(int val) {
        if(top==size-1) {
            System.out.println("Tried Pushing : " + val + ". stack overflown");
            return;
        }
        top++;
        arr[top] = val;
        System.out.println("Pushed : " + arr[top]);
    }

    void pop() {
        if(top==-1) {
            System.out.println("Underflown");
            return;
        }
        System.out.println("popped : " + arr[top]);
        top--;
    }
    int Top() {
        if(top==-1) {
            System.out.println("Underflow");
            return top;
        }
        return arr[top];
    }

    boolean isEmpty() {
        return top == -1;
    }
}

class Drivercode {
    public static void main(String[] args) {
        Stacks st = new Stacks(8);
        st.push(10);
        st.pop();
        st.pop();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);
        st.pop();
        st.push(99);
        st.push(5);
        st.push(6);
        st.push(7);
        st.push(8);
        int topval = st.Top();
        System.out.println("Top = " + topval);
        st.push(9);
    }
}