/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/**
 * Adjust the starting moving point by finding the difference between their distances
 * Time: O(a + b)
 * Space: O(1)
 */

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        
        int lengthA = length(headA);
        int lengthB = length(headB);
        
        while(lengthA > lengthB){
            headA = headA.next;
            lengthA--;
        }
        while(lengthB > lengthA){
            headB = headB.next;
            lengthB--;
        }
        
        while(headA != headB){
            headA = headA.next;
            headB = headB.next;
        }
        
        return headA;
    }
    
    private int length(ListNode head){
        int length = 0;
        
        while(head != null){
            length++;
            head = head.next; 
        }
        
        return length;
    }
}