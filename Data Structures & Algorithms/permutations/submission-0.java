class Solution {
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        createList(0, new ArrayList<>(),nums);
        return lists;
    }

    private void createList(int start, List<Integer> list, int[] nums){
        if(start == nums.length) {
            System.out.println(Arrays.toString(nums));
            lists.add(Arrays.stream(nums).boxed().toList());
            return;
        }

        for(int i = start; i< nums.length;i++){
            swap(start,i,nums);
            createList(start+1, list, nums);
            swap(start,i,nums);
        }

    }

    private void swap(int start, int i, int[] nums) {
        int temp = nums[start];
        nums[start] = nums[i];
        nums[i] = temp;
    }
}
