/**
 * Time: O(n)
 * Space: O(n)
 */

public class Solution {
    public String reverseWords(String s) {
        if(s.length() == 0){
            return s;
        }
        
        char[] string = s.toCharArray();
        
        int end = removeSpace(string);
        reverseWordsHelper(string, end);
        
        return new String(string, 0, end + 1);
    }
    
    private int removeSpace(char[] string){
        int slow = 0;
        int fast = 0;
        
        while(fast < string.length){
            if(string[fast] == ' '){
                if(slow == 0 || string[slow - 1] == ' '){
                    fast++;
                }else{
                    string[slow] = string[fast];
                    slow++;
                    fast++;
                }
            }else{
                string[slow] = string[fast];
                slow++;
                fast++;
            }
        }
        
        if(slow == 0){
            return -1;
        }
        
        return string[slow - 1] == ' ' ? slow - 2 : slow - 1;
    }
    
    private void reverseWordsHelper(char[] string, int end){
        reverse(string, 0, end);
        
        int start = 0;
        for(int i = 0; i <= end; i++){
            if(string[i] == ' '){
                reverse(string, start, i - 1);
                start = i + 1;
            }
            if(i == end){
                reverse(string, start, i);
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