class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        for (int i = 0; i < matrix.length; i++) {        // rows
            for (int j = 0; j < matrix[i].length; j++) { // columns
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println(); // move to next line after each row
        }
        
        
        int colEnd = matrix[0].length-1;

        int rowToSearch  = 0;
        for (int i = 0; i < matrix.length; i++) {
            if(matrix[i][colEnd]>=target){
                rowToSearch = i;
                break;
            }
        }

        int l = 0;
        int h = colEnd;
        System.out.println(colEnd+" "+rowToSearch);
        System.out.println("l: "+l+"  h: "+h);

        while(l<=h){
            System.out.println("Inside");
            int mid = l+ (h-l)/2;
            System.out.println(matrix[rowToSearch][mid]);
            if(matrix[rowToSearch][mid]==target){
                return true;
            }
            else if(matrix[rowToSearch][mid]>target){
                h = mid-1;
            }else{
                l = mid+1;
            }
        }
        
        return false;
    }
}
