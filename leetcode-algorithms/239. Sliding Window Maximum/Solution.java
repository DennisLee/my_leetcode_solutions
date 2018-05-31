/**
 * two array solution
 * Time : O(N)
 * Space: O(N)
 */

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return new int[0];
        }
        
        int[] maxLeft = new int[nums.length];
        int[] maxRight = new int[nums.length];
        
        maxLeft[0] = nums[0];
        maxRight[maxRight.length - 1] = nums[nums.length - 1];
        
        for(int i = 1; i < nums.length; i++){
            maxLeft[i] = (i % k == 0) ? nums[i] : Math.max(maxLeft[i - 1], nums[i]);  
        }
        
        for(int i = nums.length - 2; i >= 0; i--){
            maxRight[i] = (i % k == 0) ? nums[i] : Math.max(maxRight[i + 1], nums[i]);  
        }
        
        int result[] = new int[nums.length - k + 1];
        for(int i = 0; i < nums.length - k + 1; i++){
            result[i] = Math.max(maxLeft[i + k - 1], maxRight[i]);
            
        }
        
        return result;
    }
}

/**
 * deque solution
 * Time : O(N)
 * Space: O(N)
 */
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length == 0){
            return new int[0];   
        }
        
        Deque<Integer> q = new LinkedList<>();
        int[] result = new int[nums.length - k + 1];
        
        for(int i = 0; i < nums.length; i++){  
            
            while(!q.isEmpty() && q.peekFirst() < i - k + 1){
                q.pollFirst();
            }
            
            while(!q.isEmpty() && nums[q.peekLast()] <= nums[i]){
                q.pollLast();   
            }
            
            q.offerLast(i); 
            
            if(i >= k - 1){
                result[i - k + 1] = nums[q.peekFirst()]; 
            }
            
        }
        
        return result;
    }
}

