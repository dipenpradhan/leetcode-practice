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
    public ListNode swapNodes(ListNode head, int k) {
        
        ListNode slow = head, fast = head;
        ListNode first = null;
        int count = 1;
        
        while(fast != null){
            // System.out.println("loop count="+count);

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