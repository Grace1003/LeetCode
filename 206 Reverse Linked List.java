// Reverse a singly linked list.
// Hint: A linked list can be reversed either iteratively or recursively. Could you implement both?

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        
        ListNode prev = null;
        ListNode current = head;
        
        while(current != null){
            ListNode next = current.next;
            current.next = prev;  // reverse 
            prev = current;
            current = next;
        }
        
        return prev;  //最后状态：current为Null，prev指向最后一个非空的点，也就是翻转后的head
    }
}