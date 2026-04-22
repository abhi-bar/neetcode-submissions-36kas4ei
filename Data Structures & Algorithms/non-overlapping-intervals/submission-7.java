class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt((int[] a)-> a[1]));
        
        int topRange = intervals[0][1];
        int bottomRange =0;

        int ans = 0;
        for (int i = 1; i < n; i++) {
            if(topRange>intervals[i][0]){
                // topRange = Math.max(intervals[i][1], topRange);
                ans++;
            }else{
                topRange=intervals[i][1];
            }
        }

        return ans;
    }
}
