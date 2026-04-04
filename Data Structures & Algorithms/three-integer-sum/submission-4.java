class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> list = new ArrayList<>();
        for(int i =0; i<nums.length; i++){
            int x = nums[i];
            int l = i+1;
            int r = nums.length-1;


            while(l<r){
                if((x + nums[l] + nums[r])==0){
                    List<Integer> integers = new ArrayList<>();
                    integers.add(x);
                    integers.add(nums[l]);
                    integers.add(nums[r]);
//                    list.add(integers);
                    if(!list.contains(integers)){
                        list.add(integers);
                    }
                }

                if(nums[l]+nums[r]>-x){
                    r--;
                }else {
                    l++;
                }
            }

        }
        return list;
    }
}
