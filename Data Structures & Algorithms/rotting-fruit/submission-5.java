class Solution {
    public int orangesRotting(int[][] grid) {
        int r = grid.length;
        int c = grid[0].length;

        boolean[][] visited = new boolean[r][c];

        Queue<List<Integer>> queue = new LinkedList<>();

        int res = 0;
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(grid[i][j]==2 && !visited[i][j]){
                    List<Integer> list = new ArrayList<>();
                    list.add(i);
                    list.add(j);
                    queue.add(list);
                }
            }
        }

        res = bfsGraph(grid, visited, queue);


        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(grid[i][j]==1 && !visited[i][j]){
                    return -1;
                }
            }
        }

        return res==0?0:res-1;
    }

    private int bfsGraph(int[][] graph, boolean[][] visited,Queue<List<Integer>> queue){

        int target = 0;

        while (!queue.isEmpty()){

            int size = queue.size();
            ++target;


            for (int i = 0; i < size; i++) {

                List<Integer> pop = queue.poll();
                int r = pop.get(0);
                int c = pop.get(1);
//                System.out.println(r+" "+c);
                visited[r][c] = true;


                if(r-1>=0 && graph[r -1][c]==1 && !visited[r-1][c]){
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(r-1);
                    list1.add(c);
                    queue.add(list1);
                }
                if(r+1 < graph.length && graph[r+1][c]==1 && !visited[r+1][c]){
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(r+1);
                    list1.add(c);
                    queue.add(list1);
                }
                if(c-1>=0 && graph[r][c-1]==1 && !visited[r][c-1]){
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(r);
                    list1.add(c-1);
                    queue.add(list1);
                }
                if(c+1<graph[0].length && graph[r][c+1]==1 && !visited[r][c+1]){
                    List<Integer> list1 = new ArrayList<>();
                    list1.add(r);
                    list1.add(c+1);
                    queue.add(list1);
                }
            }
        }

        return target;
    }
}
