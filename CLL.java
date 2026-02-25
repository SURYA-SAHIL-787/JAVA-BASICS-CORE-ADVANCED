class CircularSinglyLinkedList {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    private Node tail; // tail.next is head

    // Insert at end: O(1)
    public void addLast(int x) {
        Node n = new Node(x);
        if (tail == null) {
            tail = n;
            tail.next = tail; // points to itself
        } else {
            n.next = tail.next; // new points to head
            tail.next = n;      // old tail points to new
            tail = n;           // update tail
        }
    }

    // Insert at beginning: O(1)
    public void addFirst(int x) {
        Node n = new Node(x);
        if (tail == null) {
            tail = n;
            tail.next = tail;
        } else {
            n.next = tail.next; // n -> head
            tail.next = n;      // tail -> n (new head)
        }
    }

    // Delete first occurrence: O(n)
    public boolean deleteValue(int x) {
        if (tail == null) return false;

        Node prev = tail;
        Node cur = tail.next; // head

        do {
            if (cur.data == x) {
                // single node case
                if (cur == tail && cur.next == tail) {
                    tail = null;
                    return true;
                }

                prev.next = cur.next;

                // if deleting tail, move tail back to prev
                if (cur == tail) tail = prev;

                return true;
            }
            prev = cur;
            cur = cur.next;
        } while (cur != tail.next);

        return false;
    }

    public void print() {
        if (tail == null) { System.out.println("(empty)"); return; }
        Node head = tail.next;
        Node cur = head;
        do {
            System.out.print(cur.data + (cur.next != head ? " -> " : ""));
            cur = cur.next;
        } while (cur != head);
        System.out.println(" (circular)");
    }

    public static void main(String[] args) {
        CircularSinglyLinkedList csll = new CircularSinglyLinkedList();
        csll.addLast(10);
        csll.addLast(20);
        csll.addFirst(5);
        csll.print(); // 5 -> 10 -> 20 (circular)

        csll.deleteValue(20);
        csll.print(); // 5 -> 10 (circular)
    }
}
