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

        if(root==null) return true;

        return helper(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean helper(TreeNode treeNode, int min, int max){
        if(treeNode==null) return true;

        if(treeNode.val<=min || treeNode.val>=max) return false;
        
        
        return helper(treeNode.left, min, treeNode.val) && helper(treeNode.right, treeNode.val, max);
    }
}
