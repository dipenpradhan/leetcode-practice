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
        
        ListNode f = reverse(fst);
        ListNode s = reverse(sec);
        
        ListNode res = add(f, s);
        
        return reverse(res);
    }
    
    private ListNode add(ListNode f, ListNode s){
        ListNode res = new ListNode(-1);
        ListNode n = res;
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
            n.next = new ListNode(r%10);
            n = n==null?null:n.next;
            
            f = f==null?null:f.next;
            s = s==null?null:s.next;
        }
        n.next = c>0?new ListNode(c):null;
        return res.next;
    }
    
    private ListNode reverse(ListNode n){
        ListNode p = null;
        
        while(n!=null){
            ListNode tmp = n.next;
            n.next = p;
            p = n;
            n = tmp;
        }
        return p;
    }
    
    
    private void debug(ListNode n){
        while(n!=null){
            System.out.print(n.val+" ");
            n = n.next;
        }
        System.out.println("");
    }
}