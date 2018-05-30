/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int longestConsecutive(TreeNode root) {
        if(root == null){
            return 0;  
        }
        
        return helper(root)._globalMax;
    }
    
    private HelperNode helper(TreeNode root){
        HelperNode leftResult = new HelperNode(1, 1, 1);
        HelperNode rightResult = new HelperNode(1, 1, 1);
        
        int ascendingLocalMaxFromLeft = 1;
        int descendingLocalMaxFromLeft = 1;
        if(root.left != null){
            leftResult = helper(root.left);
            ascendingLocalMaxFromLeft = root.val == root.left.val + 1 ? leftResult._ascendingLocalMax + 1 : 1;
            descendingLocalMaxFromLeft = root.val == root.left.val - 1 ? leftResult._descendingLocalMax + 1 : 1;
        }
        
        int ascendingLocalMaxFromRight = 1;
        int descendingLocalMaxFromRight = 1;
        if(root.right != null){
            rightResult = helper(root.right);
            ascendingLocalMaxFromRight = root.val == root.right.val + 1 ? rightResult._ascendingLocalMax + 1 : 1;
            descendingLocalMaxFromRight = root.val == root.right.val - 1 ? rightResult._descendingLocalMax + 1 : 1;
        }
        
        int ascendingLocalMax = Math.max(ascendingLocalMaxFromLeft, ascendingLocalMaxFromRight);
        int descendingLocalMax = Math.max(descendingLocalMaxFromLeft, descendingLocalMaxFromRight);
       
        int globalMax1 = ascendingLocalMaxFromLeft + descendingLocalMaxFromRight - 1;
        int globalMax2 = descendingLocalMaxFromLeft + ascendingLocalMaxFromRight - 1;
        int globalMax = Math.max(Math.max(leftResult._globalMax, rightResult._globalMax), Math.max(globalMax1, globalMax2));
        
        return new HelperNode(ascendingLocalMax, descendingLocalMax, globalMax);
        
    }
    
    private class HelperNode{
        int _ascendingLocalMax;
        int _descendingLocalMax;
        int _globalMax;
        public HelperNode(int ascendingLocalMax,  int descendingLocalMax, int globalMax){
            _ascendingLocalMax = ascendingLocalMax;
            _descendingLocalMax = descendingLocalMax;
            _globalMax = globalMax;
        }  
    }
}