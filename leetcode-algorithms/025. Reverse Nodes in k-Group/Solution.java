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
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if(head == null || k == 0){
            return head; 
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode end = dummy;
        
        ListNode cur = dummy.next;
        ListNode pre = dummy;
        
        while(true){
            int count = k;
            while(count >= 1 && end != null){
                end = end.next;
                count--;
            }
            
            if(end == null){
                break;
            }
            
            ListNode nextPre = cur;
            
            while(pre.next != end){
                pre.next = pre.next.next;
                cur.next = end.next;
                end.next = cur;
                //end = end.next;
                cur = pre.next;
            }
            
            pre = nextPre;
            end = pre;
            cur = pre.next;    
        }
        
        return dummy.next;
    }
}