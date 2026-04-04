class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
//        Graph Creation
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            list.add(i,new ArrayList<>());
        }
        for (int[] i: prerequisites) {
            list.get(i[0]).add(i[1]);
        }

            boolean[] visited = new boolean[numCourses];
            boolean[] recStack = new boolean[numCourses];
        
        for (int c = 0; c < numCourses; c++) {
            
            if(detectCycle(c, visited, new boolean[numCourses], list)) {
                return false;
            }
        }
        return true;
    }
    
    private boolean detectCycle(int start, boolean[] visitedB, boolean[] currentVisitedList,
                                List<List<Integer>> graph){
        
        visitedB[start] = true;
        currentVisitedList[start] = true;
        System.out.println(start);
        for(int nei: graph.get(start)){
            if(!visitedB[nei] && detectCycle(nei, visitedB, currentVisitedList, graph)){
                return true;
            } else if (currentVisitedList[nei]) {
                return true;
            }
        }
        
        currentVisitedList[start] = false;
        return false;
    }
}
