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
    public ListNode swapPairs(ListNode head) {
        ListNode prev = new ListNode(-1);
        prev.next = head;
        ListNode curr = head;
        
        ListNode result = prev;
        
        
        while(curr != null && curr.next!=null){
            
            ListNode second = curr.next;
            ListNode third = null;
            if(second != null){
                third = second.next;
                second.next = curr;
            }
            
            curr.next = third;
            prev.next = second;
            
            prev = curr;
            curr = third;
            
        }
        
        return result.next;
        
    }
}