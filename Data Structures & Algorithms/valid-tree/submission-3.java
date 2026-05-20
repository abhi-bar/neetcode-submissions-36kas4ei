class Solution {
    public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(i, new ArrayList<>());
        }
        for(int[] p: edges){
            list.get(p[0]).add(p[1]);
            list.get(p[1]).add(p[0]);
        }

        boolean[] visited = new boolean[n];

        if(cycleDetection(visited, list, 0, -1)){
            return false;
        }

        for(int i=0;i<n;i++){
            if(!visited[i]) return false;
        }
            
        

        return true;
    }

    private boolean cycleDetection(boolean[] visited, List<List<Integer>> list, int element, int parent){
        visited[element] = true;

        for (Integer i : list.get(element)) {
            if(!visited[i]){
                if(cycleDetection(visited, list, i, element)){
                    return true;
                }
            } else if (i!=parent) {
                return true;
            }
        }

        return false;
    }
}
