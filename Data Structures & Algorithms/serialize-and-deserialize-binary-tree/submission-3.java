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
    private static final String SEPARATOR = ",";
    private static final String EMPTY_NODE = "N";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr == null) {
                sb.append(EMPTY_NODE).append(SEPARATOR);
                continue;
            }

            sb.append(curr.val).append(SEPARATOR);

            q.offer(curr.left);
            q.offer(curr.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null || data.isEmpty()){
            return null;
        }

        String[] vals = data.split(SEPARATOR);

        Queue<TreeNode> q = new LinkedList<>();

        TreeNode root = new TreeNode(Integer.parseInt(vals[0]));
        q.offer(root);

        int index = 1;
        while(!q.isEmpty()){
            TreeNode curr = q.poll();

            if(!vals[index].equals(EMPTY_NODE)){
                curr.left = new TreeNode(Integer.parseInt(vals[index]));
                q.offer(curr.left);
            }

            index++;
            if(!vals[index].equals(EMPTY_NODE)){
                curr.right = new TreeNode(Integer.parseInt(vals[index]));
                q.offer(curr.right);
            }
            index++;
        }

        return root;
    }
}
