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
    public int kthSmallest(TreeNode root, int k) {
        int[] counter = new int[]{0};

        return dfs(root, k, counter);

    }

    private int dfs(TreeNode root, int k, int[] counter){
        if(root == null){
            return -1;
        }

        int left = dfs(root.left, k,counter);
        if(left != -1){
            return left;
        }

        counter[0]++;
        if(counter[0] == k){
            return root.val;
        }

        return dfs(root.right, k, counter);
    }
}

