class Solution {
    public int shipWithinDays(int[] weights, int days) {

//        Calculate sum(weights)
        int sum = Arrays.stream(weights).sum();

//        Calulate max(weights)
        int max = 0;
        for(int w: weights){
            if(w>max){
                max = w;
            }
        }

        int low = max;
        int high = sum;

        int least = sum;

        while (low<=high){
            int mid = low + (high-low)/2;

            if(calShips(weights,days,mid)){
                least = Math.min(least,mid);
                high = mid-1;
            }else {
                low = mid+1;
            }
        }

        return least;
    }

    private boolean calShips(int[] wights, int days, int limit){
        int canShip = limit;

        int totShips = 1;

        for(int w:wights){
            
            if(canShip-w<0){
                totShips++;
                if(totShips>days){
                    return false;
                }
                canShip = limit;
            }
            
            canShip -= w;
        }

        return true;
    }
}