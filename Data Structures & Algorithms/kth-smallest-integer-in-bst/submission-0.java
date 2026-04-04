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
        helper(root,k,0);
        System.out.println(as);
        return as;
    }

    int as = 0;
    int  count = 0;
    public void helper(TreeNode root, int k, int sum) {

        if(root==null) return ;

        helper(root.left, k, sum);

        count++;
        if(count==k){
            as = root.val;
            return;
        }
        helper(root.right, k, sum);
    }
}
