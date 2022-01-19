/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    
    
    /*
        dummy node as first, dummy.next = head
        slow, fast pointers = dummy
        count = 1
        
        loop until fast pointer reaches last element:
            if count is more than n:
                move slow pointer ahead
            
            move fast pointer ahead
            inc count
        
        if slow next is not null:
            update slow next to node after next
        
        return dummy.next
    */
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        // Starting from a dummy node protects us by creating an iteration with single element also
        // The iteration begins with dummy node
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        int count = 0;
        
        while(fast != null){

          if(count > n){
            slow = slow.next;
          }
          fast = fast.next;
          count++;
        }
        if(slow.next != null)
            slow.next = slow.next.next;
        
        return dummy.next;
    }
}