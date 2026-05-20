class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights){

        int r = heights.length;
        int c = heights[0].length;
        
        boolean[][] atlantic = new boolean[r][c];
        boolean[][] pacific = new boolean[r][c];

        Queue<int[]> qAtl = new LinkedList<>();
        Queue<int[]> qPtl = new LinkedList<>();

        for (int i = 0; i < c; i++) {
            qAtl.add(new int[]{0, i});
            qPtl.add(new int[]{r-1, i});
        }

        for (int i = 0; i < r; i++) {
            qAtl.add(new int[]{i,0});
            qPtl.add(new int[]{i,c-1});
        }

        smallToLarge(qAtl, atlantic, heights, r, c); 
        smallToLarge(qPtl, pacific, heights, r, c);

        List<List<Integer>> list = new ArrayList<>();
        
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if(atlantic[i][j] && pacific[i][j]){
                    list.add(List.of(i,j));
                }
            }
        }
        
        return list;
    }
    
    private void smallToLarge(Queue<int[]> queue, boolean[][] currentOcean, int[][] heights, int r, int c){
        
        while (!queue.isEmpty()){
            int l = queue.size();

            for (int i = 0; i < l; i++) {
                int[] poll = queue.poll();
                int row = poll[0];
                int col = poll[1];
                
                if(!currentOcean[row][col]) {
                    currentOcean[row][col] = true;

                    if (row - 1 >= 0 && heights[row - 1][col] >= heights[row][col]) {
                        queue.add(new int[]{row - 1, col});
                    }
                    if (row + 1 <r && heights[row + 1][col] >= heights[row][col]) {
                        queue.add(new int[]{row + 1, col});
                    }
                    if (col - 1 >= 0 && heights[row][col-1] >= heights[row][col]) {
                        queue.add(new int[]{row, col-1});
                    }
                    if (col + 1 < c && heights[row][col+1] >= heights[row][col]) {
                        queue.add(new int[]{row, col+1});
                    }
                }
            }
        }
    }
}
