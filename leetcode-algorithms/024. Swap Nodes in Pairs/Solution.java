/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * Time: O(n)
 * Space: O(1)
 */

class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        
        while(cur != null && cur.next != null){
            pre.next = cur.next;
            cur.next = pre.next.next;
            pre.next.next = cur;
            
            pre = cur;
            cur = pre.next;  
        }
        
        return dummy.next;
    }
}