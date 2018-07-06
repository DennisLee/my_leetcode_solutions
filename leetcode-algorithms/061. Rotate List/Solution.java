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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null){
            return head; 
        }
        
        ListNode dummyHead = new ListNode(0);
        dummyHead.next = head;
        
        ListNode tail = dummyHead;
        ListNode newTail = dummyHead;

        int length = 0;
        while(tail.next != null){
            tail = tail.next;
            length++;
        }
        
        for (int i = 0; i < length - k % length; i++){
            newTail = newTail.next;
        }
    
        tail.next = dummyHead.next; 
        dummyHead.next = newTail.next;
        newTail.next = null;
    
        return dummyHead.next;
    } 
}