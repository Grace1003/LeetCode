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
        ListNode dummy = new ListNode(0);   // create dummy node
        dummy.next = head;  // 把dummy放在头结点前面，此时head已经没有用了
        head = dummy;   // 所以把head当做指针，指向dummy后开始遍历
        
        while(head.next != null){
            if(head.next.val == val){
                head.next = head.next.next;
            }else{
                head = head.next;
            }
        }
        
        return dummy.next;
    }
}


My solution: 比较node.val和val，不等的节点添加到dummy node之后。
但是，九章的解法省空间和时间，推荐。
