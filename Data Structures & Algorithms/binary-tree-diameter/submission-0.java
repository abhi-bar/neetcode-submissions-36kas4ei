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
    int max = 0;
    private int height(TreeNode root) {
        if(root==null){
            return 0;
        }
        int rootL = height(root.left);
        int rootR = height(root.right);

        max = Math.max(max , Math.max(rootL+rootR, Math.max(rootL, rootR)));
        
        return Math.max(rootL, rootR)+1;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        height(root);
        return max;
    }
}
