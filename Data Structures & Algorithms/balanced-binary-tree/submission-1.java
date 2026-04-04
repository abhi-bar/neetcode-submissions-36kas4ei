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
    public boolean isBalanced(TreeNode root) {
        if(root==null) return true;

        System.out.println("Left: " +height(root.left));
        System.out.println("right: " +height(root.right));
        return Math.abs(height(root.left) - height(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }
    
    private int height(TreeNode treeNode){
        if(treeNode==null) return 0;
        // System.out.println(Math.max(height(treeNode.right), height(treeNode.left))+1);
        
        return Math.max(height(treeNode.right), height(treeNode.left))+1; 
    }
}
