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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();

        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()){

            List<Integer> list = new ArrayList<>();
            int n = queue.size();
            for (int i=0;i<n;i++){
                TreeNode poll = queue.poll();
                list.add(poll.val);
                
                if(poll.left!=null) {
                    queue.add(poll.left);
                }
                if(poll.right!=null) {
                    queue.add(poll.right);
                }
            }
            ans.add(new ArrayList<>(list));
        }

        return ans;
    }
}
