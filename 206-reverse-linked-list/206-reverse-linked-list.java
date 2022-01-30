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
        ListNode n = head;
        ListNode p = null;
        
        while(n!=null){
            ListNode tmp = n.next;
            n.next = p;
            p = n;
            n = tmp;
            
        }
        return p;
    }
}