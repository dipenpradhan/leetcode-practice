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
    public ListNode reverseList(ListNode head) {
        
        ListNode p = null; // previous
        ListNode c = head; // current
    
        while(c!=null){
            
            ListNode temp = c.next;
            c.next = p;
            p = c;
            c = temp;
            
        }
        
        return p;
        
    }
}