class Solution {
    List<List<Integer>> list = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        populateHelper(new ArrayList<>(),0,nums);
        return list;
    }

    private void populateHelper(List<Integer> list, int index, int[] nums){
        this.list.add(new ArrayList<>(list));


        if(index==nums.length){
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if(i>index && nums[i]==nums[i-1]) continue;
            list.add(nums[i]);
            populateHelper(list,i+1,nums);
            list.remove(list.size()-1);
        }
    }
}
