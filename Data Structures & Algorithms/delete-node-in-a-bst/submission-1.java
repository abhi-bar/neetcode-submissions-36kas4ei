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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root==null) return null;

        if(root.val==key) {
            if (root.right == null) {
                return root.left;
            } else {
                TreeNode left = root.left;
                TreeNode treeNode = extremeLeft(root.right);

                treeNode.left = left;
                return root.right;
            }

        }
        if(key<root.val){
            root.left=deleteNode(root.left,key);
        }else {
            root.right = deleteNode(root.right,key);
        }

        return root;
    }

    private TreeNode extremeLeft(TreeNode node){
        if(node.left==null){
            return node;
        }
        return extremeLeft(node.left);
    }
}