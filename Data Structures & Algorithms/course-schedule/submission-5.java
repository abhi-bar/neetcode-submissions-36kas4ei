class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            list.add(i, new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            list.get(pre[0]).add(pre[1]);
        }


        boolean[] visited = new boolean[numCourses];
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < numCourses; i++) {
            if(list.get(i).isEmpty()){
                queue.add(i);
//                visited[i] = true;
            }
        }

        int s =0;

        if(queue.isEmpty()) return false;

        while (!queue.isEmpty()){
            Integer poll = queue.poll();
            if(visited[poll]) continue;
            s++;
            visited[poll]=true;

            for (int i = 0; i < numCourses; i++) {
                List<Integer> list1 = list.get(i);
                list1.remove(poll);
                if(list1.isEmpty()) queue.add(i);

            }
        }

        return s==numCourses;

    }
}
