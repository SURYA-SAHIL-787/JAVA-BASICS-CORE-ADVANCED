import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Question5_SerializeAndDeserializeBinaryTree {

    public String serialize(TreeNode root) {
        if (root == null) {
            return "null";
        }

        StringBuilder result = new StringBuilder();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();

            if (node == null) {
                result.append("null,");
            } else {
                result.append(node.val).append(",");
                queue.offer(node.left);
                queue.offer(node.right);
            }
        }

        return result.toString();
    }

    public TreeNode deserialize(String data) {
        if (data == null || data.equals("null")) {
            return null;
        }

        String[] values = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        int index = 1;

        while (!queue.isEmpty() && index < values.length) {
            TreeNode parent = queue.poll();

            if (!values[index].equals("null")) {
                TreeNode leftNode = new TreeNode(Integer.parseInt(values[index]));
                parent.left = leftNode;
                queue.offer(leftNode);
            }
            index++;

            if (index < values.length && !values[index].equals("null")) {
                TreeNode rightNode = new TreeNode(Integer.parseInt(values[index]));
                parent.right = rightNode;
                queue.offer(rightNode);
            }
            index++;
        }

        return root;
    }
}
