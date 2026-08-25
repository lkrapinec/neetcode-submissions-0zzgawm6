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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int[] position = new int[1];
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            map.put(inorder[i], i);
        }
        return dfs(preorder, inorder, position, map,0, inorder.length - 1);

    }

    private TreeNode dfs(int[] preorder, int[] inorder, int[] position, Map<Integer, Integer> map, int left, int right){
        if(left > right){
            return null;
        }
        TreeNode curr = new TreeNode(preorder[position[0]]);
        position[0]++;

        int mid = map.get(curr.val);
        TreeNode leftNode = dfs(preorder, inorder, position, map,left, mid - 1);
        TreeNode rightNode = dfs(preorder, inorder, position, map, mid + 1, right);
        

        curr.left = leftNode;
        curr.right = rightNode;

        return curr;

    }
}
