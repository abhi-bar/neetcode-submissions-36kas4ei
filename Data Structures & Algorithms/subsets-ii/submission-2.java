class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        helper(nums, 0, new ArrayList<>());
        return ansList;
    }

    List<List<Integer>> ansList = new ArrayList<>();

    private void helper(int[] nums, int index, List<Integer> list){

        List<Integer> sortedNamesAsc = list.stream().sorted().toList();
//        System.out.println("Sorted list (ascending) using streams: " + sortedNamesAsc);


        if(!ansList.contains(sortedNamesAsc)) {
            ansList.add(new ArrayList<>(list));
        }


        for (int i = index; i < nums.length; i++) {
            list.add(nums[i]);
            helper(nums,i+1,list);
            list.remove(list.size()-1);
        }
    }


}
