class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        subset(nums,0,new ArrayList<>());
        return ans;
    }
    
    private void subset(int[] nums, int index, List<Integer> list){
        ans.add(new ArrayList<>(list));

        if(index>=nums.length){
            return;
        }

        
        for (int i = index; i <nums.length ; i++) {
            if(i>index && nums[i]==nums[i-1]) continue;
            list.add(nums[i]);
            subset(nums,i+1,list);
            list.removeLast();
        }
    }
}
