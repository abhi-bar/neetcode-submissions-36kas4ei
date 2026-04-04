class Solution {
    //    path
    private final int[][] series = {{-1,0},{1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        boolean[][] pacific = new boolean[heights.length][heights[0].length];
        boolean[][] atlantic = new boolean[heights.length][heights[0].length];

        Queue<int[]> pacQ = new LinkedList<>();
        Queue<int[]> atlQ = new LinkedList<>();

//        rows
        for (int i = 0; i < heights.length; i++) {
            pacQ.add(new int[]{i,0});
            atlQ.add(new int[]{i, heights[0].length-1});
        }
//        cols
        for (int i = 0; i < heights[0].length; i++) {
            pacQ.add(new int[]{0,i});
            atlQ.add(new int[]{heights.length-1,i});
        }

        bfs(heights,pacQ,pacific);
        bfs(heights,atlQ,atlantic);

        List<List<Integer>> list = new ArrayList<>();

        for (int i = 0; i < heights.length; i++) {
            for (int j = 0; j < heights[0].length; j++) {
                if(pacific[i][j] && atlantic[i][j]){
                    list.add(Arrays.asList(i,j));
                }
            }
        }
        return list;
    }

    private void bfs(int[][] heights, Queue<int[]> queue, boolean[][] ocean){
        while (!queue.isEmpty()){
            int n = queue.size();
            int[] poll = queue.poll();
            int r = poll[0];
            int c = poll[1];

            ocean[r][c] = true;

            for(int[] direction: series){
                int nr = r + direction[0];
                int nc = c + direction[1];

                if(nr>=0 && nc>=0 && nr<=heights.length-1 && nc<=heights[0].length-1
                        && heights[r][c]<=heights[nr][nc] && !ocean[nr][nc]){
                    queue.add(new int[]{nr,nc});
                }
            }
        }
    }
}
