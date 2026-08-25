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

class Solution {
    public boolean isValidBST(TreeNode root) {
        boolean left = dfs(root.left, new int[]{Integer.MIN_VALUE, root.val});
        boolean right = dfs(root.right, new int[]{root.val, Integer.MAX_VALUE});

        return left && right;
    }

    private boolean dfs(TreeNode root, int[] range){
        if(root == null){
            return true;
        }

        if(root.val <= range[0] || root.val >= range[1]){
            return false;
        }

        int max = range[1];
        range[1] = root.val;
        boolean left = dfs(root.left, range);

        range[1] = max;
        range[0] = root.val;
        boolean right = dfs(root.right,range);

        return left && right;
    }
}

