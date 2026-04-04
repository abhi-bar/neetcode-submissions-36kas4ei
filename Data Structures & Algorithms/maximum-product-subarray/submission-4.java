class Solution {
    public int maxProduct(int[] nums) {
        int currentMax = 1;
        int min = 1;

        int res = nums[0];

        for (int num : nums) {
            int temp = currentMax * num;
            currentMax = Math.max(num, Math.max(temp, min * num));
            min = Math.min(num, Math.min(temp, num * min));
            res = Math.max(res, currentMax);
        }

        return res;
    }
}
