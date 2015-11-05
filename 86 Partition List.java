Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null){
            return null;
        }
        
        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);
        ListNode left = leftDummy;
        ListNode right = rightDummy;
        
        while(head != null){
            if(head.val < x){
                left.next = new ListNode(head.val);
                left = left.next;
            }else{
                right.next = new ListNode(head.val);
                right = right.next;
            }
            head = head.next;
        }
        
        left.next = rightDummy.next;
        return leftDummy.next;
        
    }
}

在原有的链表上更改太麻烦，哪怕只改right部分
最简单的方法是判断大小后直接放入新的链表，再连起来


