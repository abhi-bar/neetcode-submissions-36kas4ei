class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l =1;
        int high = Arrays.stream(piles).max().getAsInt();
        int result = high;
        int max = 0;
        for(int pile:piles){
            max += pile;
        }

        while(l<=high){
            int mid = l + ((high - l) / 2);
            System.out.println(mid);
            int net = 0;

            for(int pile:piles){
                net += (int) Math.ceil((double) pile/mid);
            }

            System.out.println(" "+net+" "+max);
            if(net<=h){
                high = mid-1;
                result=mid;
            }else{
                l = mid+1;
            }
            
        }

        return result;
    }
}
