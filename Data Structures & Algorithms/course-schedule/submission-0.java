class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        Map<Integer, List<Integer>> hashmap = new HashMap<>();

        for(int[] i: prerequisites){
            if(hashmap.get(i[0])!=null){
                List<Integer> list = hashmap.get(i[0]);
                list.add(i[1]);
                hashmap.put(i[0], list);
            }
            else {
                List<Integer> list = new ArrayList<>();
                list.add(i[1]);
                hashmap.put(i[0], list);
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(!hashmap.containsKey(i)){
                queue.add(i);
            }
        }
//        if(queue.isEmpty() && numCourses>0) return false;



//        itterate over the queue and find the unrelated elements
        int list = 0;

        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            list++;
            for (int keys : hashmap.keySet()) {
                if (hashmap.get(keys).contains(poll)) {
                    hashmap.get(keys).remove(poll);
                    if (hashmap.get(keys).isEmpty()) {
                        
                        queue.add(keys);
                    }
                }
            }
        }

       System.out.println(list);
        return list==numCourses;
    }
}
