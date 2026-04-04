class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<>());
        return ansList;
    }

    List<List<Integer>> ansList = new ArrayList<>();

    private void helper(int[] nums, int index, List<Integer> list){
           
        if(!ansList.contains(list)) {
            ansList.add(new ArrayList<>(list));
        }


        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            helper(nums,i+1,list);
            list.remove(list.size()-1);
        }
    }


}
