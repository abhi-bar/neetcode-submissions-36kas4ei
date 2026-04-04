/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
}
*/

class Solution {
    public Node construct(int[][] grid) {
        return dfs(grid, grid.length, 0,0);
    }
    
    public Node dfs(int[][] grid, int size, int l, int r){
        if(size==1){
            return new Node(grid[l][r]==1, true);
        }

        
        int m = size/2;
        Node topLeft = dfs(grid,m,l,r);
        Node topRight = dfs(grid,m,l,r+m);
        Node bottomLeft = dfs(grid,m,l+m,r);
        Node bottomRight = dfs(grid,m,l+m,r+m);

        if(topLeft.val==topRight.val && topRight.val==bottomLeft.val && bottomLeft.val== bottomRight.val 
        && topLeft.isLeaf && topRight.isLeaf && bottomLeft.isLeaf && bottomRight.isLeaf){
            return new Node(topLeft.val, true);
        }


        return new Node(false, false, topLeft, topRight, bottomLeft, bottomRight);
    }
}