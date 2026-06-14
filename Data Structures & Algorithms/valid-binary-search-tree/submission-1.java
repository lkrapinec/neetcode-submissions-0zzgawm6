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
        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);

    }
    private boolean dfs(TreeNode root, int leftBoundary, int rightBoundary){
       if(root == null){
        return true;
       }

       if(leftBoundary >= root.val || rightBoundary <= root.val){
        return false;
       }

       return dfs(root.left, leftBoundary, root.val) && dfs(root.right, root.val, rightBoundary);
    }
}
