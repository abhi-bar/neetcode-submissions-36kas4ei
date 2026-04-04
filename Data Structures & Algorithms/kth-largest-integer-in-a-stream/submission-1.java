class KthLargest {

    PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
    int k = 0;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        for(int i:nums){
            priorityQueue.add(i);
            // if(priorityQueue.size()>3){
            //     priorityQueue.remove(priorityQueue.size()-1);
            // }
        }

    }

    public int add(int val) {
        priorityQueue.offer(val);
//        priorityQueue.of
        System.out.println(priorityQueue);
        while(priorityQueue.size()>k){
            priorityQueue.poll();
        }
        System.out.println(priorityQueue);
        return priorityQueue.peek();
    }
}
