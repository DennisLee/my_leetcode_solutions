/**
 * Time: O(lgn)
 * Space: O(1)
 */

class Solution {
    public int findMin(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        
        int left = 0;
        int right = nums.length - 1;
        
        while(left < right - 1){
            int mid = left + (right - left)/2;
            if(nums[mid] < nums[right]){
                right = mid; 
            }else{
                left = mid;
            }
            
        }
        
        return nums[left] < nums[right] ? nums[left] : nums[right];
    }
}