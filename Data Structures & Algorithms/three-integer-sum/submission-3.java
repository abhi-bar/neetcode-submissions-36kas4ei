class Solution {
    private void twoSum(int start, int[] numbers, int target,int digit) {

        int end = numbers.length-1;
        while(start<end){
//            System.out.println("target: "+ target+ " Start: "+numbers[start]+" End: "+numbers[end]);
            if(numbers[start]+numbers[end]==target){
                List<Integer> list = new ArrayList<>();
                list.add(digit);
                list.add(numbers[start]);
                list.add(numbers[end]);
//                System.out.println("res");
                start++;
                end--;
//                System.out.println(list);
                lists.add(list);
            }
            if(numbers[start]+numbers[end]>target){
                end--;
            }
            if(numbers[start]+numbers[end]<target){
                start++;
            }
        }

    }

    HashSet<List<Integer>> lists = new HashSet<>();
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        int start = 0;


        while(nums.length-start>=3){
            twoSum(start+1,nums, -nums[start], nums[start]);
            start++;
        }

        List<List<Integer>> ans = new ArrayList<>();
        for(List<Integer> set:lists){
            ans.add(set);
        }
        return ans;
    }
}
