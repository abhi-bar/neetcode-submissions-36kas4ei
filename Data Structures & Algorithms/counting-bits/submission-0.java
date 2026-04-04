class Solution {
    public int[] countBits(int n) {
        int[] arr = new int[n+1];
        for (int i = 1; i < n+1; i++) {
            arr[i]=countOne(i);
        }
        return arr;
    }
    
    private int countOne(int n){
        int count =0;
        while (n!=0){
            if((n&1)==1){
                count++;
            }
            n >>= 1;
        }
        return count;
    }
}
