class Solution {
    public int countComponents(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(i, new ArrayList<>());
        }

        for(int[] i: edges){
            list.get(i[0]).add(i[1]);
            list.get(i[1]).add(i[0]);
        }

        int count = 0;

        boolean[] visited = new boolean[n];
        for(int i=0;i<n;i++){
            if(!visited[i]){
                markVisited(list,i,-1,visited);
                count++;
            }
        }

        return count;
    }

    private void markVisited(List<List<Integer>> list, int node, int parent, boolean[] visited){
        visited[node]=true;

        for(int nei: list.get(node)){
            if(!visited[nei]){
                markVisited(list,nei,parent,visited);
            } else if (nei==parent) {
//                cycle detected here
                return;
            }
        }
    }
}
