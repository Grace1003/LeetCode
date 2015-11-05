// Given a linked list, return the node where the cycle begins. If there is no cycle, return null.
// Note: Do not modify the linked list.

// 要自己画图找各点之间的等量关系

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
    public ListNode detectCycle(ListNode head) {
        if(head == null || head.next == null){  // fast=head.next
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;  // 初识时，因为while循环的条件限制，fast不能和slow都指向head
        while(slow != fast){
            if(slow.next == null || fast.next == null || fast.next.next == null){  // slow.next判空可以省略，因为slow走在fast后面
                return null;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        
        fast = head;
        slow = slow.next;  // loop已存在，随便next。根据各点的等量关系，起点到loop开始点的距离=相遇点到loop开始点的距离-1，所以slow要next一次
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        
        return fast;
    }
}


// cc150的题
// 1. 分析各点弧长的等量关系。注意判断两点相遇时，初始时两点不能在同一位置。
// 2. 第一个loop里，目的是找到相遇点，所以用slow!=fast作为loop结束条件；而fast.next和fast.next.next的判空结果，可以直接return，所以用if语句来判断。

