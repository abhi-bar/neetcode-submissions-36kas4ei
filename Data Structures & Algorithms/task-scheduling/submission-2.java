class Solution {
    public int leastInterval(char[] tasks, int n) {

        Queue<int[]> cooldown = new LinkedList<>();

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

//        hashmap is filled
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for(char c : tasks){
            hashMap.put(c, hashMap.getOrDefault(c,0)+1);
        }

//        fill the pq
        priorityQueue.addAll(hashMap.values());

        int time  = 0;

        while (!priorityQueue.isEmpty() || !cooldown.isEmpty()){
            time++;

            if(!priorityQueue.isEmpty()){
                int poll = priorityQueue.poll();
                char val = val(hashMap, poll);
                if(poll>1){
                    cooldown.add(new int[]{val, poll-1, time + n});
                }
            }

            if(!cooldown.isEmpty() && time ==  cooldown.peek()[2]){
                priorityQueue.add(cooldown.poll()[1]);
            }
        }
        
        return time;
    }

    private char val(HashMap<Character, Integer> hashMap, int key){
        for(Map.Entry<Character, Integer> entry: hashMap.entrySet()){
            if(entry.getValue()==key){
                char cKey = entry.getKey();
                hashMap.put(cKey, hashMap.get(cKey) - 1);
                return cKey;
            }
        }

        return 0;
    }
}
