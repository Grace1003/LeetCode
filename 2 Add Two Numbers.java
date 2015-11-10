You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;  // 用head做指针去遍历，而不是用dummy
        while(l1 != null && l2 != null){
            int sum = l1.val + l2.val + carry;
            carry = sum / 10;
            head.next = new ListNode(sum % 10);
            l1 = l1.next;
            l2 = l2.next;
            head = head.next;
        }
        
        ListNode left = (l1 == null) ? l2 : l1;
        while(left != null){
            int sum = left.val + carry;
            carry = sum / 10;
            head.next = new ListNode(sum % 10);
            left = left.next;
            head = head.next;
        }
        
        if(carry != 0){
            head.next = new ListNode(carry);
        }
        
        return dummy.next;
    }
}

题中没有要求必须在原来链表上更改，新建一个链表实现起来更方便。
注意dummy node的使用方法