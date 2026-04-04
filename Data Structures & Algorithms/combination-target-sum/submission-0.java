class Solution {
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        backtrack(0,nums,target,0,new ArrayList<>());
//        for(List<Integer> list: lists){
//            System.out.println(list);
//        }
        return lists;
    }

    private void backtrack(int start, int[] nums, int target, int sum, List<Integer> list){

        if(sum==target){
            lists.add(new ArrayList<>(list));
            return;
        }

        if(sum>target){
            return;
        }


        for(int i=start; i< nums.length;i++){

            list.add(nums[i]);
            backtrack(i,nums,target,sum+nums[i],list);
//            System.out.println(list);
            list.remove(list.size()-1);
        }
    }
}
