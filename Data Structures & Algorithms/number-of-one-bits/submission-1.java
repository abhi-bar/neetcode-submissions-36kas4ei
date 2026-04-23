class Solution {
    public int hammingWeight(int n) {
        int onecount = 0;
        while (n!=0){
            if((n&1)==1){
                onecount++;
            }
            n = n>>1;
        }
        
        return onecount;
    }
}
