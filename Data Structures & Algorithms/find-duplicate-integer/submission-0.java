class Solution {
    public int findDuplicate(int[] nums) {
        int[] arr = new int[nums.length];
        
        
        for(int ele: nums){
            if(arr[ele]==-1){
                return ele;
            }
            arr[ele] = -1;
        }
        
        return -1;
    }
}
