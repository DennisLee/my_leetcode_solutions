/**
 * Time : O(N)
 * Space: O(N)
 */

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        
        for(int i = 0; i < nums.length; i++){
            set.add(nums[i]);
        }
        
        int globalMax = 0;
        
        for(int num : set){
            int localMax = 1;
            int currentNum = num;
            
            while(set.contains(currentNum + 1)){
                currentNum += 1;
                localMax += 1;
            }
            
            globalMax = Math.max(globalMax, localMax);     
        }
        
        return globalMax;
           
    }
}