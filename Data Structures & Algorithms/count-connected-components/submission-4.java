class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(i, new ArrayList<>());
        }
        for(int[] p: edges){
            list.get(p[0]).add(p[1]);
            list.get(p[1]).add(p[0]);
        }

        boolean[] visited = new boolean[n];

        // if(cycleDetection(visited, list, 0, -1)){
        //     return false;
        // }

        int size = 0;

        for(int i=0;i<n;i++){
            if(!visited[i]){
                cycleDetection(visited, list, i, -1);
                size++;
            }
        }

        return size;
    }

    private void cycleDetection(boolean[] visited, List<List<Integer>> list, int element, int parent){
        if(visited[element]) return ;

        visited[element] = true;

        for (Integer i : list.get(element)) {
            cycleDetection(visited, list, i, element);
        }
    }
}
