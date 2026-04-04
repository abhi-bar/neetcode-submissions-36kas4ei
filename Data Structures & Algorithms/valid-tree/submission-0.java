class Solution {
public boolean validTree(int n, int[][] edges) {
        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            list.add(i, new ArrayList<>());
        }

        for(int[] i: edges){
            list.get(i[0]).add(i[1]);
           list.get(i[1]).add(i[0]);
        }



        Set<Integer> visited = new HashSet<>();
//        boolean[] currentVisited = new boolean[n];
        
        if(isCycle(0,-1, list, visited)){
            return false;
        }
        return visited.size()==n;
    }


    private boolean isCycle(int node, int parent, List<List<Integer>> graph, Set<Integer> visited){
        visited.add(node);
        for(int nei: graph.get(node)){
            if(!visited.contains(nei)){
                if(isCycle(nei, node, graph, visited)){
                    return true;
                }
            }
            else if(nei!=parent){
                return true;
            }
        }

        return false;
    }
}
