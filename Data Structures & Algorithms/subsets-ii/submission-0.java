class Solution {

    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        backtrack(nums, new ArrayList<>(), 0);

//        for(List<Integer> list: lists){
//            System.out.println(list.toString());
//        }

        return lists;
    }

    private void backtrack(int[] nums, List<Integer> list, int index){


        if(index==nums.length){
            list = list.stream().sorted().toList();
            if(!lists.contains(list)) {
                lists.add(new ArrayList<>(list));
            }
            return;
        }


            list.add(nums[index]);
            backtrack(nums,list,index+1);

            list.remove(list.size()-1);
            backtrack(nums,list,index+1);

    }
}
