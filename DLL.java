class DoublyLinkedList {
    static class Node {
        int data;
        Node prev, next;
        Node(int data) { this.data = data; }
    }

    private Node head, tail;

    // Insert at beginning: O(1)
    public void addFirst(int x) {
        Node n = new Node(x);
        if (head == null) {
            head = tail = n;
        } else {
            n.next = head;
            head.prev = n;
            head = n;
        }
    }

    // Insert at end: O(1)
    public void addLast(int x) {
        Node n = new Node(x);
        if (tail == null) {
            head = tail = n;
        } else {
            tail.next = n;
            n.prev = tail;
            tail = n;
        }
    }

    // Delete first occurrence: O(n)
    public boolean deleteValue(int x) {
        Node cur = head;
        while (cur != null) {
            if (cur.data == x) {
                if (cur.prev != null) cur.prev.next = cur.next;
                else head = cur.next; // deleting head

                if (cur.next != null) cur.next.prev = cur.prev;
                else tail = cur.prev; // deleting tail

                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public void printForward() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data + (cur.next != null ? " <-> " : ""));
            cur = cur.next;
        }
        System.out.println();
    }

    public void printBackward() {
        Node cur = tail;
        while (cur != null) {
            System.out.print(cur.data + (cur.prev != null ? " <-> " : ""));
            cur = cur.prev;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        DoublyLinkedList dll = new DoublyLinkedList();
        dll.addFirst(10);
        dll.addLast(20);
        dll.addLast(30);
        dll.printForward();  // 10 <-> 20 <-> 30
        dll.printBackward(); // 30 <-> 20 <-> 10

        dll.deleteValue(20);
        dll.printForward();  // 10 <-> 30
    }
}
