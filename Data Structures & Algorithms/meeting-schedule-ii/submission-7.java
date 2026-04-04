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
        if(intervals.isEmpty()) return 0;
        int[][] array = new int[intervals.size()][2];

        int index = 0;
        for(Interval i:intervals){
            array[index][0]=i.start;
            array[index][1]=i.end;
            index++;
        }

        Arrays.sort(array, (a, b) -> Integer.compare(a[0], b[0]));

        List<int[]> list = new ArrayList<>();
        Collections.addAll(list, array);


        List<int[]> list2 = new ArrayList<>();


        int[] compare = new int[2];
        compare=array[0];

        int count=0;

        int index2 = 1;
        while(!list.isEmpty()){
            if(index2>=list.size()){
                if(list2.isEmpty()){
                    count++;
                    break;
                }
                count++;
                index2=1;
                list=list2;
                list2= new ArrayList<>();
                compare[0]=list.get(0)[0];
                compare[1]=list.get(0)[1];
                System.out.println(Arrays.toString(compare));
            }

            else {
            if (compare[1] > list.get(index2)[0]) {
                    list2.add(list.get(index2));
                } else {
                    compare[0] = list.get(index2)[0];
                    compare[1] = list.get(index2)[1];
                }
            index2++;
            }

        }

        System.out.println(count);
        return count;
    }
}
