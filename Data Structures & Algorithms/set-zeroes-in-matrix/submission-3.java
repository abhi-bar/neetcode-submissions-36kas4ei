class Solution {
    public void setZeroes(int[][] matrix) {
//        make a list of all elements having 0 as a value
        Set<int[]> set = new HashSet<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j]==0){
//                    setZeros(matrix,i,j);
                    set.add(new int[]{i,j});
                }
            }
        }
        
        for(int[] m:set){
            setZeros(matrix,m[0],m[1]);
        }
    }
    
    private void setZeros(int[][] matrix, int i, int j){
        // if(matrix.length==1){
        //     Arrays.fill(matrix[0],0);
        //     return;
        // }
        // if(matrix[0].length==1){
        //     Arrays.stream(matrix).forEach(row->Arrays.fill(row,0));
        //     return;
        // }
        for (int k = 0; k < matrix.length; k++) {
//            matrix[i][k]=0;
            matrix[k][j]=0;
        }
        for (int k = 0; k < matrix[0].length; k++) {
            matrix[i][k]=0;
//            matrix[k][j]=0;
        }
    }
}
