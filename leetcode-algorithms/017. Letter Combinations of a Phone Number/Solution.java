class Solution {
    private static final String[] KEYS = { "", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz" };
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        
        if(digits == null || digits.length() == 0){
            return result;
        }
        
        StringBuilder sb = new StringBuilder("");
        DFS(result, sb, 0, KEYS, digits);
        return result;
    }
    
    private void DFS(List<String> result, StringBuilder sb, int index, String[] keys, String digits){
        if(index == digits.length()){
            result.add(sb.toString());
            return;
        }
        
        int num = Character.getNumericValue(digits.charAt(index));
        for(int i = 0; i < keys[num].length(); i++){
            sb.append(keys[num].charAt(i));
            DFS(result, sb, index + 1, keys, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
}