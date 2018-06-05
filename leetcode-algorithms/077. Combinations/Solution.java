
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        return helper(0, 0, n, k);
    }
    
    private List<List<Integer>> helper(int length, int val, int n, int k){
        List<List<Integer>> result = new ArrayList<>();
        
        if(length == k){
            result.add(new LinkedList<>(Arrays.asList(val)));  
        }
        
        for(int i = val + 1; i <= n; i++){
            if((length + (n - i)) >= k - 1){
                List<List<Integer>> childResult = helper(length + 1, i, n, k);
                for(List<Integer> list: childResult){
                    if(val != 0){
                        list.add(val);  
                    }
                    result.add(list); 
                } 
            }
        }
        
        return result;  
    }
}