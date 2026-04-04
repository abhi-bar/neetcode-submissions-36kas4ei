class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < edges.length+1; i++) {
            list.add(i, new ArrayList<>());
        }

        for(int[] i: edges){
            list.get(i[0]).add(i[1]);
            list.get(i[1]).add(i[0]);System.out.println(list.size());
            boolean[] visited = new boolean[edges.length+1];
            if(isCycle(i[0],-1,list,visited)){
                return i;
            }
        }

        return null;
    }

    private boolean isCycle(int node, int parent, List<List<Integer>> list, boolean[] visited){


        visited[node] = true;

        for(int nei: list.get(node)){
            if(!visited[nei]){
                if(isCycle(nei,node,list,visited)){
                    return true;
                }
            }else if(nei!=parent){
                return true;
            }
        }

        return false;
    }
}
