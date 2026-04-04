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
    
    public boolean isSameTree(TreeNode p, TreeNode q) {
        List<TreeNode> list1 = new ArrayList<>();
        getList(p, list1);

        List<TreeNode> list2 = new ArrayList<>();
        getList(q, list2);

        if(list1.size()!=list2.size()){
            return false;
        }
        
        int l=0;
        while(l<list2.size()){
            if((list1.get(l)==null && list2.get(l)!=null) || (list1.get(l)!=null && list2.get(l)==null)){
                return false;
            }
            else if((list1.get(l)!=null && list2.get(l)!=null) && list1.get(l).val != list2.get(l).val){
                return false;
            }
            l++;
        }
        
        return true;
    }

    private void getList(TreeNode treeNode, List<TreeNode> list){
        if(treeNode==null){
            list.add(null);
            return;
        }

        list.add(treeNode);
        getList(treeNode.left, list);
        getList(treeNode.right, list);
    }
}
