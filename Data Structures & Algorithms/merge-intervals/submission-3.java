class Solution {
    public int[][] merge(int[][] intervals) {
        
        List<Integer> newInterval = new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));



        for(int[] individuals : intervals){
            if(!newInterval.isEmpty()){
                if(individuals[0]<=newInterval.get(1)){
                    int y = newInterval.remove(1);
                    int x = newInterval.remove(0);
                    newInterval.add(0,Math.min(x, individuals[0]));
                    newInterval.add(Math.max(y,individuals[1]));
                }else {
                    ans.add(new ArrayList<>(newInterval));
                    newInterval = new ArrayList<>();
                    newInterval.add(individuals[0]);
                    newInterval.add(individuals[1]);
                }
            }else {
                newInterval.add(individuals[0]);
                newInterval.add(individuals[1]);
            }
        }

        if(!newInterval.isEmpty()) {
            ans.add(new ArrayList<>(newInterval));
        }

        int[][] ant = new int[ans.size()][2];
        int index=0;
        for(List<Integer> list: ans){
            ant[index][0]= list.get(0);
            ant[index][1]= list.get(1);
            index++;
        }

        return ant;        
    }
}
