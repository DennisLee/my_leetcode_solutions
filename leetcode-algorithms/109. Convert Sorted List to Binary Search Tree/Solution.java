/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * the middle element is the root at that level of the tree
 * Time: O(n)
 * Space: O(lgn)
 */

class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null){
            return null;
        }
        
        return BSTHelper(head, null);
    }
    
    private TreeNode BSTHelper(ListNode head, ListNode tail){
        if(head == tail){
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != tail && fast.next != tail){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        TreeNode treeHead = new TreeNode(slow.val);
        treeHead.left = BSTHelper(head, slow);
        treeHead.right = BSTHelper(slow.next, tail);
        
        return treeHead;
    }
}