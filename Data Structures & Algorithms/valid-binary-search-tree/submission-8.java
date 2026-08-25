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
        boolean left = dfs(root.left, Integer.MIN_VALUE, root.val);
        boolean right = dfs(root.right, root.val, Integer.MAX_VALUE);

        return left && right;
    }

    private boolean dfs(TreeNode root, int min, int max){
        if(root == null){
            return true;
        }

        if(root.val <= min || root.val >= max){
            return false;
        }

        boolean left = dfs(root.left, min, root.val);
        boolean right = dfs(root.right,root.val, max);

        return left && right;
    }
}

