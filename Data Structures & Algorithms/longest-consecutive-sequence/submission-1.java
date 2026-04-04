class Solution {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();

        for(int ele:nums){
            set.add(ele);
        }

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for(int i = 0; i < nums.length; i++) {
            if(!set.contains(nums[i]-1)){
                hashMap.put(nums[i],1);
            }
        }

        for(int ele:hashMap.keySet()){
            int e2 = ele+1;
            while(set.contains(e2)){
                hashMap.put(ele,hashMap.get(ele)+1);
                e2++;
            }
        }

        int max =0;
        for (int val: hashMap.values()){
            max = Math.max(val,max);
        }

        return max;

    }
}
