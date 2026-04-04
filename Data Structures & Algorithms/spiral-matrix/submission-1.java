class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        int topRow = 0, topColumn = 0;
        int bottomRow = matrix.length-1;
        int bottomCol = matrix[0].length-1;

        List<Integer> list = new ArrayList<>();

        while (topRow<=bottomRow && topColumn<=bottomCol){

            if(topRow==bottomRow){
                for (int i = topColumn; i <=bottomCol ; i++) {
                    list.add(matrix[topRow][i]);
                }
                return list;
            }
            if(topColumn==bottomCol){
                for (int i = topRow; i <=bottomRow ; i++) {
                    list.add(matrix[i][topColumn]);
                }
                return list;
            }
            for (int i = topColumn; i <=bottomCol; i++) {
                list.add(matrix[topRow][i]);
            }
            for (int i = topRow+1; i <=bottomRow; i++) {
                list.add(matrix[i][bottomCol]);
            }
            for (int i = bottomCol-1; i>=topColumn ; i--) {
                list.add(matrix[bottomRow][i]);
            }
            for (int i = bottomRow-1; i >topRow ; i--) {
                list.add(matrix[i][topColumn]);
            }
            topRow++;
            bottomRow--;

            topColumn++;
            bottomCol--;

        }

        return list;
    }
}
