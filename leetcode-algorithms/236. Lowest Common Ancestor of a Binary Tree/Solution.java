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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return helper(root, p, q)._node;
    }
    
    private HelperNode helper(TreeNode root, TreeNode p, TreeNode q){
        if(root == null){
            return new HelperNode(null, false, false);
        }
        
        HelperNode leftResult = helper(root.left, p, q);
        HelperNode rightResult = helper(root.right, p, q);
        
        boolean hasP = leftResult._hasP || rightResult._hasP || root == p;
        boolean hasQ = leftResult._hasQ || rightResult._hasQ || root == q;
        TreeNode node = (leftResult._hasP && leftResult._hasQ) ? leftResult._node :
                        (rightResult._hasP && rightResult._hasQ) ? rightResult._node :
                        root;
        
        return new HelperNode(node, hasP, hasQ);
    }
    
    private class HelperNode{
        TreeNode _node;
        boolean _hasP;
        boolean _hasQ;
        public HelperNode(TreeNode node, boolean hasP, boolean hasQ){
            _node = node;
            _hasP = hasP;
            _hasQ = hasQ; 
        }
            
    }
}