Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;  // 返回dummy.next，没必要再标记一次头结点
        head = dummy;   // 用dummy标记了新的头结点后，可以移动head去遍历
        
        while(head.next != null){
            if(head.next.next != null && head.next.val == head.next.next.val){
                int val = head.next.val;
                while(head.next != null && head.next.val == val){
                    head.next = head.next.next;
                }
            }else{
                head = head.next;
            }
        }
        
        return dummy.next;
    }
}


和九章一模一样
