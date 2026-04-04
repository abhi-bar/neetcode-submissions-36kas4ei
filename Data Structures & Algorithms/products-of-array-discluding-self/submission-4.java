class Solution {
    public int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        int[] prev = new int[l];
        prev[0]=nums[0];

        int[] next = new int[l];
        next[l-1]=nums[l-1];

        int[] ans = new int[l];

        for (int i = 1; i < l; i++) {
            prev[i] = prev[i-1]*nums[i];
        }
        System.out.println(Arrays.toString(prev));

        for (int i = l-2; i >=0; i--) {
            next[i] = next[i+1]*nums[i];
        }
        System.out.println(Arrays.toString(next));

        for (int i = 0; i < l; i++) {
            if(i>0 && i<l-1){
                ans[i] = prev[i-1]*next[i+1];
            }else if(i==0){
                ans[i] = next[i+1];
            }else if(i==l-1){
                ans[i] = prev[i-1];
            }
        }


        return ans;       
    }
}  
