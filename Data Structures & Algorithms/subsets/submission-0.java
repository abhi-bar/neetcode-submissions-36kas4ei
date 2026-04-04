class Solution {
    List<List<Integer>> listingList = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        sub(0,nums, new ArrayList<>());
        return listingList;
    }

    public void sub(int i, int[] nums, List<Integer> curr){
        if(i == nums.length){
//            System.out.println(curr);
            listingList.add(new ArrayList<>(curr));
            return;
        }


        List<Integer> pick = new ArrayList<>(curr);
        pick.add(nums[i]);

        sub(i+1, nums, pick);
        sub(i+1,nums, curr);
    }
}
