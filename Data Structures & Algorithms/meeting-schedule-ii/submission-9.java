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
    public int minMeetingRooms(List<Interval> intervals) {
int[] start = new int[intervals.size()];
        int[] end = new int[intervals.size()];

        int index  =0;

        for(Interval i: intervals){
            start[index]=i.start;
            end[index]=i.end;
            index++;
        }

        Arrays.sort(start);
        Arrays.sort(end);


        int s =0;
        int e=0;
        int count  =0;
        int res=0;

        while (e<intervals.size() && s<intervals.size()){
            if(start[s]<end[e]){
                s++;
                count++;
            }else {
                e++;
                count--;
            }
            res = Math.max(res,count);
        }

        System.out.println(count);
        return res;
    }
}
