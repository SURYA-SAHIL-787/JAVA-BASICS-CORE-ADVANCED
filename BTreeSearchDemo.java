class SearchBTreeNode {
    int[] keys;
    int t;
    SearchBTreeNode[] children;
    int n;
    boolean leaf;

    public SearchBTreeNode(int t, boolean leaf) {
        this.t = t;
        this.leaf = leaf;
        this.keys = new int[2 * t - 1];
        this.children = new SearchBTreeNode[2 * t];
        this.n = 0;
    }

    public SearchBTreeNode search(int key) {
        int i = 0;

        while (i < n && key > keys[i]) {
            i++;
        }

        if (i < n && keys[i] == key) {
            return this;
        }

        if (leaf) {
            return null;
        }

        return children[i].search(key);
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

    public void splitChild(int i, SearchBTreeNode y) {
        SearchBTreeNode z = new SearchBTreeNode(y.t, y.leaf);
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

class SearchBTree {
    SearchBTreeNode root;
    int t;

    public SearchBTree(int t) {
        this.root = null;
        this.t = t;
    }

    public void insert(int key) {
        if (root == null) {
            root = new SearchBTreeNode(t, true);
            root.keys[0] = key;
            root.n = 1;
        } else {
            if (root.n == 2 * t - 1) {
                SearchBTreeNode s = new SearchBTreeNode(t, false);
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

    public boolean searchKey(int key) {
        return root != null && root.search(key) != null;
    }
}

public class BTreeSearchDemo {
    public static void main(String[] args) {
        SearchBTree tree = new SearchBTree(3);

        int[] values = {15, 8, 22, 5, 9, 18, 30, 3, 7};
        for (int value : values) {
            tree.insert(value);
        }

        int key1 = 18;
        int key2 = 100;

        System.out.println("Search " + key1 + ": " + (tree.searchKey(key1) ? "Found" : "Not Found"));
        System.out.println("Search " + key2 + ": " + (tree.searchKey(key2) ? "Found" : "Not Found"));
    }
}
