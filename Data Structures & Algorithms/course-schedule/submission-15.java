class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        boolean[] visited = new boolean[numCourses];
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            list.add(i, new ArrayList<>());
        }
        for(int[] p: prerequisites){
            list.get(p[0]).add(p[1]);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i]) {
                if (detectUnidirectionCycle(visited, new boolean[numCourses], list, i, numCourses)) {
                    return false;
                }
            }
        }
        
        return true;
    }

//    using local-visited and global-visited
    private boolean detectUnidirectionCycle(boolean[] visited, boolean[] localVisited,
                                           List<List<Integer>> list, int element, int numCourse){

        visited[element] = true;
        localVisited[element] = true;


        for (Integer i : list.get(element)) {
            if(!visited[i]){
                if(detectUnidirectionCycle(visited, localVisited, list, i, numCourse)){
                    return true;
                }
            }else if(localVisited[i]){
                return true;
            }
        }

        localVisited[element] = false;

        return false;
    }
}
