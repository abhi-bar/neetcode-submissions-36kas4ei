class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(m==0){
            for (int i = 0; i < nums1.length; i++) {
                nums1[i]=nums2[i];
            }
        }else {
            int leftM =0;
            int leftN =0;

            while (m>0 && leftM<nums1.length && leftN<nums2.length){
                if(nums1[leftM] <= nums2[leftN]){
                    leftM++;
                    m--;
                }else {
                    rightShift(nums1,leftM);
                    nums1[leftM] = nums2[leftN];
                    leftN++;
                    leftM++;
                }
            }

            if(leftN<n){
                for (int i = leftM; i <nums1.length ; i++) {
                    nums1[i] = nums2[leftN];
                    leftN++;
                }
            }
        }
    }

    private void rightShift(int[] nums, int index){
        int prev = nums[index];

        int curr ;
        for (int i = index+1; i <nums.length ; i++) {
            curr = nums[i];
            nums[i] = prev;
            prev= curr;
        }
    }

}