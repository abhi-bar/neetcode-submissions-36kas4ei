class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        helper(candidates, target, 0, new ArrayList<>(),0);
        return ansList;
    }

    List<List<Integer>> ansList = new ArrayList<>();

    private void helper(int[] nums, int target, int index, List<Integer> list, int sum){

         if(sum==target){
             if(!ansList.contains(list)) {
                 ansList.add(new ArrayList<>(list));
             }
             return;
         }

         if(sum>target){
             return;
         }

        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            helper(nums,target,i+1,list, sum+nums[i]);
            list.remove(list.size()-1);
        }
    }
}
