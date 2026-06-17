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
    private static final char SEPARATOR = '|';
    // private static final String EMPTY_NODE = "n";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        TreeNode emptyNode = new TreeNode(Integer.MIN_VALUE);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                if (curr.val == Integer.MIN_VALUE) {
                    sb.append(Integer.MIN_VALUE).append(SEPARATOR);
                    continue;
                }

                sb.append(curr.val).append(SEPARATOR);
                if (curr.left == null) {
                    curr.left = emptyNode;
                }
                q.offer(curr.left);

                if (curr.right == null) {
                    curr.right = emptyNode;
                }
                q.offer(curr.right);
            }
            
        }

        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if(data.isBlank()){
            return null;
        }

        List<TreeNode> nodes = new ArrayList<>();

        int lastPosition = 0;
        for(int i = 0; i < data.length(); i++){
            if(data.charAt(i) == SEPARATOR){
                int val = Integer.parseInt(data.substring(lastPosition, i));
                lastPosition = i + 1;

                nodes.add(new TreeNode(val)); 
            }
        }
        int l = 1;
        for(int i = 0; l < nodes.size(); i++){
            TreeNode curr = nodes.get(i);

            if(curr.val == Integer.MIN_VALUE){
                continue;
            }
            
            TreeNode left = nodes.get(l);
            TreeNode right = nodes.get(l+1);

            if(left.val != Integer.MIN_VALUE){
                curr.left = left;
            }

            if(right.val != Integer.MIN_VALUE){
                curr.right = right;
            }

        l += 2;
        }

        return nodes.get(0);
    }
}

// issue how to send empty child
//solution is to create new node with min value
//is there better approach?

//1,2,3,null,null,4,5
//0,1,2,  3. , 4 ,5,6

//0 left = 1, right = 2 
//1 left = 3, right = 4 
//2 left = 5, right = 6
//3 left = 7, right = 8
//4 left = 9, right = 10
//5 left = 11, right = 12


//1,null,3,4,5,6,7

//                  1
//        null               3
//.  null     null        4      5
//null null null null null null 6 7
