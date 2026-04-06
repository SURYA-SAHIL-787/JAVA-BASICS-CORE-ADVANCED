import java.util.Scanner;

class MenuBTreeNode {
    int[] keys;
    int t;
    MenuBTreeNode[] children;
    int n;
    boolean leaf;

    public MenuBTreeNode(int t, boolean leaf) {
        this.t = t;
        this.leaf = leaf;
        this.keys = new int[2 * t - 1];
        this.children = new MenuBTreeNode[2 * t];
        this.n = 0;
    }

    public void traverse() {
        int i;
        for (i = 0; i < n; i++) {
            if (!leaf) {
                children[i].traverse();
            }
            System.out.print(keys[i] + " ");
        }

        if (!leaf) {
            children[i].traverse();
        }
    }

    public MenuBTreeNode search(int key) {
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

    public void splitChild(int i, MenuBTreeNode y) {
        MenuBTreeNode z = new MenuBTreeNode(y.t, y.leaf);
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

class MenuBTree {
    MenuBTreeNode root;
    int t;

    public MenuBTree(int t) {
        this.root = null;
        this.t = t;
    }

    public void traverse() {
        if (root != null) {
            root.traverse();
        } else {
            System.out.println("Tree is empty.");
        }
    }

    public boolean search(int key) {
        return root != null && root.search(key) != null;
    }

    public void insert(int key) {
        if (root == null) {
            root = new MenuBTreeNode(t, true);
            root.keys[0] = key;
            root.n = 1;
        } else {
            if (root.n == 2 * t - 1) {
                MenuBTreeNode s = new MenuBTreeNode(t, false);
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
}

public class BTreeOperationsDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MenuBTree tree = new MenuBTree(3);

        while (true) {
            System.out.println("\n--- B-Tree Operations ---");
            System.out.println("1. Insert");
            System.out.println("2. Search");
            System.out.println("3. Traverse");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    int insertValue = sc.nextInt();
                    tree.insert(insertValue);
                    System.out.println("Inserted successfully.");
                    break;

                case 2:
                    System.out.print("Enter value to search: ");
                    int searchValue = sc.nextInt();
                    System.out.println(tree.search(searchValue) ? "Key found." : "Key not found.");
                    break;

                case 3:
                    System.out.print("B-Tree traversal: ");
                    tree.traverse();
                    System.out.println();
                    break;

                case 4:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}
