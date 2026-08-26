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
    private static final String EMPTY_NODE = "E";
    private static final String SEPARATOR = "#";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null){
            return "";
        }
        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        StringBuilder sb = new StringBuilder();
        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();

            if(curr == null){
                sb.append(EMPTY_NODE).append(SEPARATOR);
                continue;
            }

            sb.append(curr.val).append(SEPARATOR);
            queue.offer(curr.left);
            queue.offer(curr.right);
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isBlank()){
            return null;
        }

        String[] values = data.split(SEPARATOR);
        int index = 0;

        Queue<TreeNode> queue = new LinkedList<>();

        int value = Integer.parseInt(values[index]);
        index++;
        TreeNode root = new TreeNode(value);

        queue.offer(root);

        while(!queue.isEmpty()){
            TreeNode curr = queue.poll();

            if(curr == null){
                continue;
            }

            String leftValue = values[index];
            index++;

            if(!leftValue.equals(EMPTY_NODE)){
                TreeNode left = new TreeNode(Integer.parseInt(leftValue));
                curr.left = left;
                queue.offer(left);
            }

            String rightValue = values[index];
            index++;
            if(!rightValue.equals(EMPTY_NODE)){
                TreeNode right = new TreeNode(Integer.parseInt(rightValue));
                curr.right = right;
                queue.offer(right);
            }
        }

        return root;
    }
}
