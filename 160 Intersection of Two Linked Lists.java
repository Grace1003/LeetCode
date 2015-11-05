Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:
A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.

Notes:
If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.

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
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null){
            return null;
        }
        
        ListNode a = headA;
        ListNode b = headB;
        while(a.next != null && b.next != null){
            a = a.next;
            b = b.next;
        }
        
        ListNode longList = new ListNode(0);
        ListNode shortList = new ListNode(0);
        int distance = 0;
        if(a.next == null){
            longList = headB;
            shortList = headA;
            while(b.next != null){
                b = b.next;
                distance++;
            }
        }else{
            longList = headA;
            shortList = headB;
            while(a.next != null){
                a = a.next;
                distance++;
            }
        }
        
        if(a != b){   // 两个链表相交的判断条件：尾节点相同！
            return null;
        }
        for(int i = 0; i < distance; i++){
            longList = longList.next;
        }
        while(shortList != longList){
            shortList = shortList.next;
            longList = longList.next;
        }
        
        return longList;
        
    }
}

先判断尾节点是否相等
再利用链表长度差让长链表先走几步
最后同时move节点，找到相遇点