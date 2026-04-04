class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        
        for (int i:stones){
            priorityQueue.add(i);
        }
        
        int reached = 0;
        while(priorityQueue.size()>=0){
            if(priorityQueue.size()==0){
                return 0;
            }
            if(priorityQueue.size()==1){
                return priorityQueue.poll();
            }
            
            int x1 = priorityQueue.poll();
            int x2 = priorityQueue.poll();
            
            priorityQueue.add(Math.abs(x2-x1));
        }
        
        return reached;   
    }
}
