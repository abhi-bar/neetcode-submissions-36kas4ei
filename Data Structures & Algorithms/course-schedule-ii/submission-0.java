class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        int[] indiff = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph.add(i,new ArrayList<>());
        }
        for(int[] i: prerequisites){
            graph.get(i[0]).add(i[1]);
            indiff[i[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(indiff[i]==0){
                queue.add(i);
            }
        }

        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            list.add(poll);
            for(int nei: graph.get(poll)){
                indiff[nei]--;
                if(indiff[nei]==0){
                    queue.add(nei);
                }
            }
        }

        Collections.reverse(list);
        // list = list.reversed();

        return list.size()==numCourses?list.stream().mapToInt(Integer::intValue).toArray():new int[0] ;
    }
}
