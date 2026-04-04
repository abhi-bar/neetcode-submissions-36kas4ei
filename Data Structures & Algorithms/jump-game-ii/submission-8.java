class Solution {
    public int jump(int[] nums) {
        if(nums.length<2){
            return 0;
        }
        int l = 0;
        int r = nums[l];

        int steps = 1;
        while(r<nums.length-1){
            steps++;
            int max = 0;
            int index = 0;
            for (int i = l; i <=r; i++) {
                if(nums[i]-(r-i) > max){
                    index = i;
                    max = nums[i]-(r-i);
                }
            }
            l = index;
            if(l>nums.length-1 || max+r >= nums.length-1){
                System.out.println("break");
                break;
            }
            r = nums[l]+r;
        }

        return steps;
    }
}
