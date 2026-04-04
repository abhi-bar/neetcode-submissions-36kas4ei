class Solution {
    public void islandsAndTreasure(int[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid[0].length];
        Queue<int[]> queue = new LinkedList<>();

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0 && !visited[i][j]) {
                    queue.add(new int[]{i, j});
                    bfsGraph(grid, visited, queue);
                }
            }
        }
    }

    private void bfsGraph(int[][] graph, boolean[][] visited, Queue<int[]> queue) {

        int target = 1;
        while (!queue.isEmpty()) {

            int size = queue.size();


            for (int i = 0; i < size; i++) {

                int[] pop = queue.poll();
                int r = pop[0];
                int c = pop[1];
//                System.out.println(r+" "+c);
                visited[r][c] = true;


                if (r - 1 >= 0 && graph[r - 1][c] > target) {
                    graph[r - 1][c] = target;
                    queue.add(new int[]{r - 1, c});
                }
                if (r + 1 < graph.length && graph[r + 1][c] > target) {
                    graph[r + 1][c] = target;
                    queue.add(new int[]{r + 1, c});
                }
                if (c - 1 >= 0 && graph[r][c - 1] > target) {
                    graph[r][c-1] = target;
                    queue.add(new int[]{r, c - 1});
                }
                if (c + 1 < graph[0].length && graph[r][c + 1] > target) {
                    graph[r][c+1] = target;
                    queue.add(new int[]{r, c + 1});
                }
            }
            target++;
        }
    }
}
