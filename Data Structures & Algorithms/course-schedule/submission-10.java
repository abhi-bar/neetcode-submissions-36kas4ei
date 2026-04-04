class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            list.add(i,new ArrayList<>());
        }

        for(int[] i: prerequisites){
            list.get(i[0]).add(i[1]);
        }

        boolean[] visited = new boolean[numCourses];

        for (int i = 0; i < numCourses; i++) {
            if(dfsCycle(i, visited, new ArrayList<>(), list)){
                return false;
            }
        }
        return true;
    }

    private boolean dfsCycle(int ele, boolean[] visited, List<Integer> completed, List<List<Integer>> list){

        visited[ele] = true;
        completed.add(ele);

        for(Integer nei: list.get(ele)){
            if(!visited[nei]){
                if(dfsCycle(nei, visited, completed, list)) {
                    return true;
                }
            } else if (completed.contains(nei)) {
                return true;
            }
        }

        completed.remove(completed.size()-1);
        return false;
    }
}
