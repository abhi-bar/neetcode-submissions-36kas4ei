class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            list.add(i, new ArrayList<>());
        }
        for(int[] p: prerequisites){
            list.get(p[0]).add(p[1]);
            indegree[p[1]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if(indegree[i]==0){
                queue.add(i);
            }
        }

        List<Integer> list1 = new ArrayList<>();
        int size = 0;

        while (!queue.isEmpty()){
            int n = queue.size();
            size++;

            for (int i = 0; i < n; i++) {
                Integer poll = queue.poll();
                list1.add(poll);
                for (Integer integer : list.get(poll)) {
                    indegree[integer]--;
                    if(indegree[integer]==0){
                        queue.add(integer);
                    }
                }
            }
        }
        Collections.reverse(list1);
        return list1.size()==numCourses?list1.stream().mapToInt(Integer::intValue).toArray():new int[0] ;
    }
}
