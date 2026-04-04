class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int l = 0;
        int r = k;

        int[] ans = new int[nums.length-k+1];
        int index = 0;
        while(r<=nums.length){
            System.out.println(Arrays.toString(Arrays.copyOfRange(nums, l, r)));
            ans[index] = max(Arrays.copyOfRange(nums,l,r));
            l++;
            r++;
            index++;
        }
        return ans;
    }
    private int max(int[] arr){
        int max = Integer.MIN_VALUE;
        for (int j : arr) {
            max = Math.max(max, j);
        }

        return max;
    }
}
