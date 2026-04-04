class Solution {
    public int climbStairs(int n) {
        if(n==2) return 2;
        if(n==1) return 1;

        int i = 1;
        int j = 2;

        int[] arr = new int[n];
        arr[0] = i;
        arr[1] = j; 

        for(int x=2;x<n;x++){
            arr[x] = arr[x-1] + arr[x-2];
        }

        return arr[n-1];
    }
}
