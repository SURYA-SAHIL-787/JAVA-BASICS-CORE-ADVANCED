class SinglyLinkedList {
    // Node for SLL
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    private Node head;

    // Insert at beginning: O(1)
    public void addFirst(int x) {
        Node n = new Node(x);
        n.next = head;
        head = n;
    }

    // Insert at end: O(n)
    public void addLast(int x) {
        Node n = new Node(x);
        if (head == null) { head = n; return; }
        Node cur = head;
        while (cur.next != null) cur = cur.next;
        cur.next = n;
    }

    // Delete first occurrence of value: O(n)
    public boolean deleteValue(int x) {
        if (head == null) return false;
        if (head.data == x) { head = head.next; return true; }

        Node prev = head, cur = head.next;
        while (cur != null) {
            if (cur.data == x) {
                prev.next = cur.next;
                return true;
            }
            prev = cur;
            cur = cur.next;
        }
        return false;
    }

    // Search: O(n)
    public boolean contains(int x) {
        Node cur = head;
        while (cur != null) {
            if (cur.data == x) return true;
            cur = cur.next;
        }
        return false;
    }

    // Display: O(n)
    public void print() {
        Node cur = head;
        while (cur != null) {
            System.out.print(cur.data + (cur.next != null ? " -> " : ""));
            cur = cur.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        SinglyLinkedList sll = new SinglyLinkedList();
        sll.addFirst(10);
        sll.addFirst(5);
        sll.addLast(20);
        sll.print(); // 5 -> 10 -> 20

        System.out.println(sll.contains(10)); // true
        sll.deleteValue(10);
        sll.print(); // 5 -> 20
    }
}
