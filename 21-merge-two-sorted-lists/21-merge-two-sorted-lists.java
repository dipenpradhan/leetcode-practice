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
    public ListNode mergeTwoLists(ListNode f, ListNode s) {
        
        ListNode r = new ListNode(-1);
        ListNode n = r;
        
        while(f != null || s != null){
            
            if(f != null && s != null){
                if(f.val <= s.val){
                    n.next = f;
                    f = f.next;
                }else{
                    n.next = s;
                    s = s.next;
                }
            }else if (f == null){
                n.next = s;
                break;
            }else{
                n.next = f;
                break;
            }
            n = n.next;
            
        }
        return r.next;
   
    }
}