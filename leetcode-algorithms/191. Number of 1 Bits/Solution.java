//Solution 1
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        
        for(int i = 1; i <= 32; i++) {
            if((n & mask) != 0){
                bits++;
            }
            mask <<= 1; 
        }
        
        return bits;
    }
}



//Solution 2
public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int bits = 0;
        
        while(n != 0){
            bits++;
            n = n & (n - 1);   
        }
        
        return bits;
    }
}