class Solution {
    public int trap(int[] height) {
        int maxLeft  = height[0];
        int maxRight = height[height.length-1];

        int l = 0;
        int r = height.length-1;

        int globalAns = 0;

        while(r>l){
            if(height[l]>height[r]){
                maxRight = Math.max(maxRight, height[r-1]);
                globalAns += maxRight-height[r-1];
                r--;
            }
            else{
                maxLeft = Math.max(maxLeft, height[l+1]);
                globalAns += maxLeft-height[l+1];
                l++;
            }
        }

        return globalAns;
    }
}
