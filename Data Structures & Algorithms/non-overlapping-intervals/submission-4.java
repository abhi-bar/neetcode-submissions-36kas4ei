class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt((int[] a)-> a[1]));

        // System.out.println(Arrays.toString(intervals[1]));
        int preEnd = intervals[0][1];
        int and = 0;

        for (int i = 1; i < intervals.length; i++) {
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];

            if(preEnd>nextStart){
                and++;
            }else {
                preEnd=nextEnd;
            }
        }

        return and;
    }
}
