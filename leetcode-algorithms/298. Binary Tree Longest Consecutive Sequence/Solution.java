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
        HelperNode leftResult = new HelperNode(1, 1);
        HelperNode rightResult = new HelperNode(1, 1);
        
        int localMaxFromLeft = 1;
        int localMaxFromRight = 1;
        
        if(root.left != null){
            leftResult = helper(root.left); 
            localMaxFromLeft = root.val == root.left.val - 1 ? leftResult._localMax + 1 : 1;
        }
        if(root.right != null){
            rightResult = helper(root.right);  
            localMaxFromRight = root.val == root.right.val - 1 ? rightResult._localMax + 1 : 1;
        }
        
        int localMax = Math.max(localMaxFromLeft, localMaxFromRight);
        int globalMax = Math.max(localMax, Math.max(leftResult._globalMax, rightResult._globalMax));
        
        return new HelperNode(localMax, globalMax);
    }
    
    private class HelperNode{
        int _localMax;
        int _globalMax;
        public HelperNode(int localMax, int globalMax){
            _localMax = localMax;
            _globalMax = globalMax;
        }  
    }
}