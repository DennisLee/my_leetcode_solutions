/**
 * use bit operation XOR to flip the bits
 * Time: O(n)
 * Space: O(1)
 */

class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        for(int i = 0; i < A.length; i++){
            int length = A[i].length;
            
            for(int j = 0; j < (length + 1)/2; j++){
                int temp = A[i][j];
                A[i][j] = A[i][length - 1 - j] ^ 1;
                A[i][length - 1 - j] = temp ^ 1;
                
            }  
        }
        
        return A;
    }
}