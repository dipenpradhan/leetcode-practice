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
        Add a dummy node before head
        set dummy.next to head
        
        curr = dummy
        
        loop until curr and curr.next are not null:

            first   =  curr.next
            second  =  first.next
            third   =  second.next
            
            if second not null
                curr.next = second
                second.next = first
                first.next = third
            
            curr = first
        
    
    */
    
    public ListNode swapPairs(ListNode head) {
       
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode curr = dummy;
        
        while(curr != null && curr.next!=null){
            
            ListNode first = curr.next;
            ListNode second = first.next;
            
            if(second != null){
                ListNode third = second.next;
                curr.next = second;
                second.next = first;
                first.next = third;
            }
            
            curr = first;
            
        }
        
        
        return dummy.next;
        
    }
}