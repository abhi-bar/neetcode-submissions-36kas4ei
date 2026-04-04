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
    public int goodNodes(TreeNode root) {
        if(root==null) return 0;
        count(root, Integer.MIN_VALUE, root.val);
        return size;
    }
    int size  = 0;
    private void count(TreeNode node, int max, int root){
        if(node==null){
            return;
        }
        
        if(node.val>=max && node.val>=root){
            size++;
        }
//        max = Math.max(max, node.val);
        
        count(node.left, Math.max(max, node.val), root);
        count(node.right, Math.max(max, node.val), root);
    }
}
