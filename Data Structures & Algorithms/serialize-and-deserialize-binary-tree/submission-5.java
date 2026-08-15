/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {
    private static final String EMPTY = "N";
    private static final String SEPARATOR = "#";

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
        if (root == null) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (curr == null) {
                sb.append(EMPTY).append(SEPARATOR);
                continue;
            }

            sb.append(curr.val).append(SEPARATOR);
            ;

            queue.offer(curr.left);
            queue.offer(curr.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }

        String[] values = data.split(SEPARATOR);
        int index = 0;
        TreeNode head = new TreeNode(Integer.parseInt(values[index]));
        index++;

        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(head);

        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();

            if (!values[index].equals(EMPTY)) {
                TreeNode left = new TreeNode(Integer.parseInt(values[index]));
                queue.offer(left);

                curr.left = left;
            }
            index++;
            if (!values[index].equals(EMPTY)) {
                TreeNode right = new TreeNode(Integer.parseInt(values[index]));
                queue.offer(right);

                curr.right = right;
            }
            index++;
        }
        return head;
    }
}
