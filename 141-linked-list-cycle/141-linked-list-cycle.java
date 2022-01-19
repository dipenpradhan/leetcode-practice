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
    
  /*
    slow, fast pointers
    slow moves to slow.next
    fast moves to fast.next.next for each iteration
    
    if slow and fast meet:
      cycle found
      
    no cycle
  */
  
  public boolean hasCycle(ListNode head){
    
    ListNode slow = head, fast = head;
    
    while(fast != null && fast.next != null){
      
      slow = slow.next;
      fast = fast.next.next;
      
      if(slow == fast){
        return true;
      }
      
    }
    
    return false;
    
  }
}