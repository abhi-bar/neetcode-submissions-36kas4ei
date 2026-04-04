class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        count(0,nums,target,0,0);
        return ourCount;
    }

    int ourCount = 0;

    private void count(int count, int[] nums, int target, int sum, int index){
//        if(sum==target){
////            System.out.println(sum);
//            ourCount++;
//        }

        if(index>nums.length-1 || count==nums.length*2){
            if(sum==target){
//            System.out.println(sum);
                ourCount++;
            }
//            System.out.println(sum);
            return;
        }


        count(count+1, nums, target, sum+nums[index], index+1);
        count(count+1, nums, target, sum-nums[index], index+1);
    }
}
