class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);

        List<List<Integer>> arrayList = new ArrayList<>();

        for (int i = 0; i < nums.length-3 ; i++) {
            while (i>0 && i<nums.length-3 && nums[i]==nums[i-1])i++;
            int l = i+1;
            int r = nums.length-1;
            int sum = target-nums[i];
            for (List<Integer> list : sum3(Arrays.copyOfRange(nums,l,r+1), sum)) {
                list.addFirst(nums[i]);
                arrayList.add(list);
            }
        }

        return arrayList;
    }

    public List<List<Integer>> sum3(int[] nums, int target){

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < nums.length-2; i++) {

            while (i>0 && i<nums.length-2 && nums[i]==nums[i-1])i++;

            int l =i+1;
            int r=nums.length-1;

            while (l<r){
                long sum = (long) nums[i]+nums[l]+nums[r];
                if(sum==target){
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(nums[i]);
                    list1.add(nums[l]);
                    list1.add(nums[r]);

                    l++;
                    r--;

                    list.add(list1);

                    while (l<r && nums[l]==nums[l-1]) l++;
                    while (l<r && nums[r]==nums[r+1]) r--;
                } else if (sum<target) {
                    l++;
                }else {
                    r--;
                }
            }


        }
        return list;
    }
}