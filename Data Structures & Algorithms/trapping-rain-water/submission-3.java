class Solution {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length-1;

        int maxLeft = height[left];
        int maxRight = height[right];

        int vol = 0;

        while(left<=right){
            if (maxLeft <= maxRight) {
                if (height[left] < maxLeft) {
                    vol += maxLeft - height[left]; // water trapped
                } else {
                    maxLeft = height[left]; // update max
                }
                left++;
            } else {
                if (height[right] < maxRight) {
                    vol += maxRight - height[right]; // water trapped
                } else {
                    maxRight = height[right]; // update max
                }
                right--;
            }
        }
        return vol;
    }
}
