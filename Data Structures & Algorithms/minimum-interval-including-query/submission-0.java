class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
//        hashmap can be implemented but will be less optimised than PQ since for all elements from 1-end in interval
//        hashmap needs to be there

//        HashMap<Integer, Integer> hashMap = new HashMap<>();
//        for(int[] ints: intervals){
//            hashMap.put(ints[0], hashMap.getOrDefault(Math.min(ints[0],ints[1]-ints[0]),Math.min(ints[0],ints[1]-ints[0])));
//        }


        Arrays.sort(intervals, (a,b)->Integer.compare(a[0],b[0]));

        int[] output = new int[queries.length];
        int index  = 0;
        for(int i:queries){
            output[index]=pq(intervals,i);
            index++;
        }

        System.out.println(Arrays.toString(output));
        return output;
    }


    private int pq(int[][] interval, int query){
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for(int[] i:interval){
            if(i[0]<=query && i[1]>=query){
                priorityQueue.add(i[1]-i[0]+1);
            }
        }


        return priorityQueue.isEmpty()?-1: priorityQueue.poll();
    }
}
