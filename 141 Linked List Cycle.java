// Given a linked list, determine if it has a cycle in it.
// Follow up: Can you solve it without using extra space?

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        
        ListNode slow = head.next;
        ListNode fast = head.next.next;
        while(fast!= null && fast.next != null && fast.next.next != null){  //fast跳点赋值，所以要判断fast,fast.next是否为NULL
            if(slow == fast){
                return true;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }
}