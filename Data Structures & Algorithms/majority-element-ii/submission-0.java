class Solution {
    public List<Integer> majorityElement(int[] nums) {
        int s = nums.length/3;

        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        List<Integer> l = new ArrayList<>();
        for(Integer k: map.keySet()){
            if(map.get(k)>s){
                l.add(k);
            }
        }

        return l;

    }
}