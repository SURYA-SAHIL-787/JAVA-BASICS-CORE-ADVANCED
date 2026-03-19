import java.util.*;

public class SerializeDeserializeBinaryTree {

    static class TreeNode {
        int val;
        TreeNode left, right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static class Codec {

        public String serialize(TreeNode root) {
            if (root == null) return "";

            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while (!queue.isEmpty()) {
                TreeNode node = queue.poll();

                if (node == null) {
                    sb.append("null,");
                    continue;
                }

                sb.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }

            return sb.toString();
        }

        public TreeNode deserialize(String data) {
            if (data == null || data.isEmpty()) return null;

            String[] values = data.split(",");
            TreeNode root = new TreeNode(Integer.parseInt(values[0]));
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            int i = 1;

            while (!queue.isEmpty() && i < values.length) {
                TreeNode current = queue.poll();

                if (!values[i].equals("null")) {
                    current.left = new TreeNode(Integer.parseInt(values[i]));
                    queue.offer(current.left);
                }
                i++;

                if (i < values.length && !values[i].equals("null")) {
                    current.right = new TreeNode(Integer.parseInt(values[i]));
                    queue.offer(current.right);
                }
                i++;
            }

            return root;
        }
    }

    public static void printLevelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                System.out.print("null ");
                continue;
            }
            System.out.print(node.val + " ");
            queue.offer(node.left);
            queue.offer(node.right);
        }
        System.out.println();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        Codec codec = new Codec();
        String data = codec.serialize(root);
        System.out.println("Serialized: " + data);

        TreeNode newRoot = codec.deserialize(data);
        System.out.print("Deserialized Tree: ");
        printLevelOrder(newRoot);
    }
}
