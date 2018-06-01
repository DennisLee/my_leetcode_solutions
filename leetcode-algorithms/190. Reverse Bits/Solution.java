public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int result = 0;
        int mask = 1;
        
        for(int i = 1; i <= 32; i++){
            if((n & mask) != 0){
                result += 1;
            }
            mask <<= 1;
            
            //do not shift the last digit because n is an unsigned int
            if(i <= 31){
                result <<= 1;  
            }
            
            
        }
        
        return result;
    }
}