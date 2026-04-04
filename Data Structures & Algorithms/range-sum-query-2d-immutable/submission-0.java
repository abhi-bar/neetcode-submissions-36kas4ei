class NumMatrix {

    public int[][] sum;

    public NumMatrix(int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;

        sum = new int[row][col];

        for (int i = row-1; i>=0; i--) {
            for (int j = col-1; j>=0; j--) {
                sum[i][j]+=matrix[i][j];
                if (i<row-1){
                    sum[i][j] += sum[i+1][j];
                }

                if(j<col-1){
                    sum[i][j] += sum[i][j+1];
                }

                if (i < row - 1 && j < col - 1) sum[i][j] -= sum[i + 1][j + 1];
            }
        }

        for(int i =0;i<row;i++){
            for(int j =0;j<col;j++){
                System.out.print("   " + sum[i][j] + "    ");
            }
            System.out.println();
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        sum = this.sum[row1][col1];

        int below =0;
        if(row2<this.sum.length-1){
            below = this.sum[row2+1][col1];
        }

        int right = 0;
        if(col2<this.sum[0].length-1){
            right = this.sum[row1][col2+1];
        }

        int mix = 0;
        if(row2<this.sum.length-1 && col2<this.sum[0].length-1){
            mix = this.sum[row2+1][col2+1];
        }

        System.out.println(below+" "+right+" "+mix);
        return sum - (below + right) + mix;
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */