class StackLinkedList {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    private Node top; // head as top

    public boolean isEmpty() { return top == null; }

    public void push(int x) {
        Node n = new Node(x);
        n.next = top;
        top = n;
    }

    public int pop() {
        if (isEmpty()) throw new RuntimeException("Stack Underflow");
        int val = top.data;
        top = top.next;
        return val;
    }

    public int peek() {
        if (isEmpty()) throw new RuntimeException("Stack is empty");
        return top.data;
    }

    public void print() {
        Node cur = top;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        StackLinkedList st = new StackLinkedList();
        st.push(5);
        st.push(15);
        st.push(25);
        st.print();          // 25 15 5
        System.out.println(st.pop()); // 25
        st.print();          // 15 5
    }
}
