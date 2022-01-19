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
        ListNode slow = head, fast = head;
        ListNode cycleHead = null;
        
        while(fast != null && fast.next != null){
            
            slow = slow.next;
            fast = fast.next.next;
            if(cycleHead != null){
                cycleHead = cycleHead.next;
            }
            if(slow == fast && cycleHead == null){
                cycleHead = head;
            }
            
            if(cycleHead == slow){
                return cycleHead;
            }
        }
        return cycleHead;
    }
}

/*
    s -1 f -1
    s -7 f 7
    s 7 f 19
    s -4 f -9
    s 19 f -2 
    s 6 f 6.   c = -1
    s -9 f     c = -7
    s -5 f     c = 7 
    s -2 f     c = -4
    s -5 f     c = 19
    s  6       c = 6
*/