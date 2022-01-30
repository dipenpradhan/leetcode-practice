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
    public ListNode addTwoNumbers(ListNode fst, ListNode sec) {
        return add(fst, sec);
    }
    
    private ListNode add(ListNode f, ListNode s){
        ListNode res = new ListNode(-1);
        ListNode head = res;
        int c = 0;
        while(f!=null || s!=null){
            int r = 0;
            if(f!=null && s!=null){
                r = f.val + s.val + c;
            }else if(f!=null){
                r = f.val + c;
            }else{
                r = s.val + c;
            }
            c = r/10;
            r = r%10;
            res.next = new ListNode(r);
            res = res.next;
            f = f==null?null:f.next;
            s = s==null?null:s.next;
        }
        if(c>0) res.next = new ListNode(c);
        return head.next;
    }
}