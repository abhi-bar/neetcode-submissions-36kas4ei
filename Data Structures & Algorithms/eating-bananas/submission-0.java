class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l =1;
        int high = Arrays.stream(piles).max().getAsInt();
        int result = 1;
        while(l<=high){
            int mid = l + (high - l) / 2;
            int net = 0;

            for(int pile:piles){
                net += (int) Math.ceil((double) pile/mid);
            }

            if(net<=h){
                result=mid;
                high = mid-1;
            }else{
                l = mid+1;
            }
        }

        return result;
    }
}
