/**;
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
        slow, fast pointers
        first, second pointers to store elements to swap
        count = 1
        
        loop until fast exceeds end of list (fast=null):
            
            slow begins moving when count > k (it will be at length-k when fast hits end)
            first = fast when count == k
            fast moves every iteration
            
    
    */
    
    public ListNode swapNodes(ListNode head, int k) {
        
        ListNode slow = head, fast = head;
        ListNode first = null;
        int count = 1;
        
        // run until last value of fast (end of list)
        while(fast != null){
            
            if(count == k){
                first = fast;
            }
            if(count > k){
                slow = slow.next;
            }
            fast = fast.next;
            count++;
        }
        
        swapNodes(first, slow);
        
        return head;
  
    }
    
    private void swapNodes(ListNode first, ListNode second){
        
        if(first == null || second == null) return;
        
        int temp = first.val;
        first.val = second.val;
        second.val = temp;
        
    }
    
}