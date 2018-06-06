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