/**
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        int matrixRow = matrix.length;
        int matrixCol = matrix[0].length;
        
        for(int i = 0; i < matrixCol; i++){
            int row = 0;
            int col = i;
            int num = matrix[row][col];
            while(row < matrixRow && col < matrixCol){
                if(matrix[row][col] != num){
                    return false;
                }
                row++;
                col++;
            }
        }
        
        for(int i = 0; i < matrixRow; i++){
            int row = i;
            int col = 0;
            int num = matrix[row][col];
            while(row < matrixRow && col < matrixCol){
                if(matrix[row][col] != num){
                    return false;
                }
                row++;
                col++;
            }
        }
        
        return true;
    }
}

/**
 * Compare with the top-left element
 * Time: O(n)
 * Space: O(1)
 */
class Solution {
    public boolean isToeplitzMatrix(int[][] matrix) {
        for (int r = 0; r < matrix.length; r++){
            for (int c = 0; c < matrix[0].length; c++){
                if (r > 0 && c > 0 && matrix[r-1][c-1] != matrix[r][c]){
                    return false;
                }
            }
        }
         
        return true;
    }
}
