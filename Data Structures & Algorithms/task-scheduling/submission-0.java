class Solution {
    public int leastInterval(char[] tasks, int n) {

        Queue<int[]> cooldown = new LinkedList<>();
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());

        int time = 0;

        HashMap<Character, Integer> hashMap = new HashMap<>();

        for(char c:tasks){
            hashMap.put(c, hashMap.getOrDefault(c,0)+1);
        }
        priorityQueue.addAll(hashMap.values());

        while (!priorityQueue.isEmpty() || !cooldown.isEmpty()){
            time++;

            if (!priorityQueue.isEmpty()){
                int freq = priorityQueue.poll();
                char key = key(freq, hashMap);

                if(freq-1>0){
                    cooldown.add(new int[]{key, freq-1, time+n});
                }
            }

            if(!cooldown.isEmpty() && time == cooldown.peek()[2]){
                int[] task = cooldown.poll();
                priorityQueue.add(task[1]);
            }

        }
        return time;
    }

    // Returns the char that has the given frequency, and reduces its count
    private char key(int value, HashMap<Character, Integer> map) {
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            if (entry.getValue() == value) {
                char c = entry.getKey();
                map.put(c, value - 1);   // reduce by 1
                return c;
            }
        }
        return 0;
    }
}
