class QueueLinkedList {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    private Node front, rear;

    public boolean isEmpty() { return front == null; }

    public void enqueue(int x) {
        Node n = new Node(x);
        if (rear == null) { // empty
            front = rear = n;
        } else {
            rear.next = n;
            rear = n;
        }
    }

    public int dequeue() {
        if (isEmpty()) throw new RuntimeException("Queue Underflow");
        int val = front.data;
        front = front.next;
        if (front == null) rear = null; // became empty
        return val;
    }

    public int peek() {
        if (isEmpty()) throw new RuntimeException("Queue is empty");
        return front.data;
    }

    public void print() {
        Node cur = front;
        while (cur != null) {
            System.out.print(cur.data + " ");
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        QueueLinkedList q = new QueueLinkedList();
        q.enqueue(5);
        q.enqueue(15);
        q.enqueue(25);
        q.print();                 // 5 15 25
        System.out.println(q.dequeue()); // 5
        q.print();                 // 15 25
    }
}
