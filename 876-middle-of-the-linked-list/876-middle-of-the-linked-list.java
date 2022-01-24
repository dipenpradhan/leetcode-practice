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
    public ListNode middleNode(ListNode head) {
        int c = 0;
        
        ListNode n = head;
        
        while(n != null){
            c++;
            n = n.next;
        }
        n = head;
        for(int i = 0; i < (c % 2 == 0 ? Math.ceil(c/2f):c/2) ; i++){
            n = n.next;
        }
        return n;
        
    }
}