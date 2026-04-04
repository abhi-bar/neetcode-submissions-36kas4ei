class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int index = 0;
        List<int[]> list = new ArrayList<>();

//        Collections.addAll(list, intervals);

        for(int[] interval: intervals){
            if(newInterval==null || newInterval[0]>interval[1]){
                list.add(interval);
            } else if (newInterval[1]<interval[0]){
                list.add(newInterval);
                list.add(interval);
                newInterval=null;
            }
            else{
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            }
        }

        if(newInterval!=null) list.add(newInterval);

        System.out.println(list.size());

        for(int[] i: list){
            System.out.println(Arrays.toString(i));
        }

        return list.toArray(new int[list.size()][]);
    }
}
            