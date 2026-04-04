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
        helper(root);
        System.out.println(list);
        return list.size()==0?0:list.get(k-1);
    }
    
    List<Integer> list = new ArrayList<>();
    
    private void helper(TreeNode node){
        if(node==null){
            return;
        }

        helper(node.left);
        list.add(node.val);
        helper(node.right);
    }
}
