class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> list = new ArrayList<>();
        helper(list,nums,target,new ArrayList<>(),0,0);
        return list;
    }

    private void helper(List<List<Integer>> lists,int[] nums, int target, List<Integer> list, int value, int index){
        if(value==target){
            lists.add(new ArrayList<>(list));
            return;
        }
        if(value>target) return;

        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            helper(lists,nums,target,list,value+nums[i],i);
            list.remove(list.size()-1);
        }
    }
}
