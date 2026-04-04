class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                Comparator.comparingInt((int[] a)->a[1])
                        .thenComparingInt(a->a[2]));

        for (int i = 0; i < arr.length; i++) {
            pq.add(new int[]{arr[i], Math.abs(x-arr[i]), i});
        }

        List<Integer> list = new ArrayList<>();

        int[] ax = new int[k];
        
        for (int i = 0; i <k ; i++) {
            int[] poll = pq.poll();
            ax[i]=poll[0];
        }

        Arrays.sort(ax);
        for(Integer i:ax){
            list.add(i);
        }
        
        return list;
    }
}