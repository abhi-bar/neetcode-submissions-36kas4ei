/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        int[][] array = new int[intervals.size()][2];

        int index = 0;
        for(Interval i:intervals){
            array[index][0]=i.start;
            array[index][1]=i.end;
            index++;
        }

        Arrays.sort(array, (a, b) -> Integer.compare(a[0], b[0]));

        for (int i = 1; i < array.length; i++) {
            if(array[i-1][1]>array[i][0]){
                return false;
            }
        }
        
        
        return true;
    }
}
