class TraversalBTreeNode {
    int[] keys;
    int t;
    TraversalBTreeNode[] children;
    int n;
    boolean leaf;

    public TraversalBTreeNode(int t, boolean leaf) {
        this.t = t;
        this.leaf = leaf;
        this.keys = new int[2 * t - 1];
        this.children = new TraversalBTreeNode[2 * t];
        this.n = 0;
    }

    public void traverseInOrder() {
        int i;
        for (i = 0; i < n; i++) {
            if (!leaf) {
                children[i].traverseInOrder();
            }
            System.out.print(keys[i] + " ");
        }
        if (!leaf) {
            children[i].traverseInOrder();
        }
    }

    public void insertNonFull(int key) {
        int i = n - 1;

        if (leaf) {
            while (i >= 0 && keys[i] > key) {
                keys[i + 1] = keys[i];
                i--;
            }
            keys[i + 1] = key;
            n++;
        } else {
            while (i >= 0 && keys[i] > key) {
                i--;
            }

            if (children[i + 1].n == 2 * t - 1) {
                splitChild(i + 1, children[i + 1]);

                if (keys[i + 1] < key) {
                    i++;
                }
            }
            children[i + 1].insertNonFull(key);
        }
    }

    public void splitChild(int i, TraversalBTreeNode y) {
        TraversalBTreeNode z = new TraversalBTreeNode(y.t, y.leaf);
        z.n = t - 1;

        for (int j = 0; j < t - 1; j++) {
            z.keys[j] = y.keys[j + t];
        }

        if (!y.leaf) {
            for (int j = 0; j < t; j++) {
                z.children[j] = y.children[j + t];
            }
        }

        y.n = t - 1;

        for (int j = n; j >= i + 1; j--) {
            children[j + 1] = children[j];
        }

        children[i + 1] = z;

        for (int j = n - 1; j >= i; j--) {
            keys[j + 1] = keys[j];
        }

        keys[i] = y.keys[t - 1];
        n++;
    }
}

class TraversalBTree {
    TraversalBTreeNode root;
    int t;

    public TraversalBTree(int t) {
        this.root = null;
        this.t = t;
    }

    public void insert(int key) {
        if (root == null) {
            root = new TraversalBTreeNode(t, true);
            root.keys[0] = key;
            root.n = 1;
        } else {
            if (root.n == 2 * t - 1) {
                TraversalBTreeNode s = new TraversalBTreeNode(t, false);
                s.children[0] = root;
                s.splitChild(0, root);

                int i = 0;
                if (s.keys[0] < key) {
                    i++;
                }
                s.children[i].insertNonFull(key);

                root = s;
            } else {
                root.insertNonFull(key);
            }
        }
    }

    public void traverse() {
        if (root != null) {
            root.traverseInOrder();
        }
    }
}

public class BTreeTraversalDemo {
    public static void main(String[] args) {
        TraversalBTree tree = new TraversalBTree(3);

        int[] values = {50, 20, 70, 10, 30, 60, 80, 25, 35};
        for (int value : values) {
            tree.insert(value);
        }

        System.out.println("In-order traversal of B-Tree:");
        tree.traverse();
    }
}
