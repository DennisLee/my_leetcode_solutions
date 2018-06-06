/**
 * Time: O(r * c)
 * Space: O(r * c)
 */

class Solution {
    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int numsRow = nums.length;
        int numsCol = nums[0].length;
        
        if(r * c != numsRow * numsCol){
            return nums;
        }
        
        int[][] result = new int[r][c];
        int count = 0;
        
        for(int i = 0; i < numsRow; i++){
            for(int j = 0; j < numsCol; j++){ 
                result[count/c][count%c] = nums[i][j];
                count++;
            }
        }
        
        return result;
    }
}