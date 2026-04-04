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

        return create(grid,0,0,grid.length);
    }

    private Node create(int[][] grid, int left, int right, int size){
        if(size==1){
            return new Node(grid[left][right]==1,true);
        }

        int m = size/2;
        Node topLeft =  create(grid,left,right,m);
        Node topRight =  create(grid,left,right+m,m);
        Node bottomLeft =  create(grid,left+m,right,m);
        Node bottomRight =  create(grid,left+m,right+m,m);

        if(topLeft.isLeaf && topRight.isLeaf && bottomRight.isLeaf && bottomLeft.isLeaf &&
        topLeft.val==topRight.val &&
        topRight.val == bottomLeft.val &&
        bottomLeft.val == bottomRight.val){
            return new Node(topLeft.val, true);
        }

        return new Node(false,false,topLeft,topRight,bottomLeft,bottomRight);
    }
}