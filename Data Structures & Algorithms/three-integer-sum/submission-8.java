class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        
        int ele = 0;
        int l =1;
        int r =nums.length-1;
        
        
        
        List<List<Integer>> ans = new ArrayList<>();
        while (l<r){
            if(nums[l] + nums[ele] + nums[r] == 0){
                List<Integer> ele1 = List.of(nums[ele], nums[l], nums[r]);
                
                if(!ans.contains(ele1)) {
                    ans.add(new ArrayList<>(ele1));
                }
                
                l++;
                r--;
            } else if (nums[l] + nums[ele] + nums[r] < 0){
                l++;
            }else {
                r--;
            }

            if(l>=r && ele!=nums.length-2){
                ele+=1;
                l = ele+1;
                r = nums.length-1;
            }
        }
        
        return ans;
    }
}
