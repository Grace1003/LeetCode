Remove all elements from a linked list of integers that have value val.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode dummy = new ListNode(0);
        ListNode newHead = dummy;
        
        while(head != null){
            if(head.val != val){
                dummy.next = new ListNode(head.val);
                dummy = dummy.next;
            }
            head = head.next;
        }
        
        return newHead.next;
    }
}