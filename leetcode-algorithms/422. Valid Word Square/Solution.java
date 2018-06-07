
/**
 * Time: O(n)
 * Space: O(1)
 */

class Solution {
    public boolean validWordSquare(List<String> words) {
        int rowSize = words.size();
        
        for(int row = 0; row < rowSize; row++){
            for(int col = 0; col < words.get(row).length(); col++){
                // too long || too short || the characters are not the same
                if(col >= rowSize || words.get(col).length() <= row || words.get(row).charAt(col) != words.get(col).charAt(row)){
                    return false; 
                }
            }
        }
        
        return true;
    }
}