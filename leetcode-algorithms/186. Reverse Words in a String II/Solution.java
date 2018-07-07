/**
 * Time: O(n)
 * Space: O(1)
 */

class Solution {
    public void reverseWords(char[] str) {
        reverse(str, 0, str.length - 1);
        
        int start = 0;
        for(int end = 0; end < str.length; end++){
            if(str[end] == ' '){
                reverse(str, start, end - 1);
                start = end + 1;
            }
            if(end == str.length - 1){
                reverse(str, start, end);
            }
        }
    }
    
    private void reverse(char[] input, int left, int right){
        while(left < right){
            char temp = input[left];
            input[left] = input[right];
            input[right] = temp;
            
            left++;
            right--;
        }
    }
}