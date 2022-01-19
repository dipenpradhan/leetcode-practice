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
    
//     public ListNode swapNodes(ListNode head, int k) {
        
//         ListNode slow = head, fast = head;
//         ListNode first = null;
//         int count = 1;
        
//         // run until last value of fast (end of list)
//         while(fast != null){
            
//             if(count == k){
//                 first = fast;
//             }
//             if(count > k){
//                 slow = slow.next;
//             }
//             fast = fast.next;
//             count++;
//         }
        
//         swapNodes(first, slow);
        
//         return head;
  
//     }
    
//     private void swapNodes(ListNode first, ListNode second){
        
//         if(first == null || second == null) return;
        
//         int temp = first.val;
//         first.val = second.val;
//         second.val = temp;
        
//     }
    
    
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
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode slow = dummy, fast = dummy;
        ListNode first = null;
        int count = 0;
        
        // run until last value of fast (end of list)
        while(fast != null){
            
            if(count < k){
                first = fast;
            }
            if(count > k){
                slow = slow.next;
            }
            fast = fast.next;
            count++;
        }
        
        swapNodes(first, slow);
        
        return dummy.next;
  
    }
    
    private void swapNodes(ListNode beforeFirst, ListNode beforeSecond){
        
        if(beforeFirst == null || beforeSecond == null) return;
        System.out.println("beforeFirst="+beforeFirst.val+" beforeSecond="+beforeSecond.val);
        ListNode bf = beforeFirst, f = beforeFirst.next, af = f.next;
        
        ListNode bs = beforeSecond, s = beforeSecond.next, as = s.next;

        // System.out.println("bf="+bf.val+" f="+f.val+" af="+af.val+" bs="+bs.val+" s="+s.val+" as="+as.val);

        if(f == bs){
            bf.next = s;
            s.next = f;
            f.next = as;
        }else if(s == bf){
            bs.next = f;
            f.next = bf;
            bf.next = af;
        }
        else {
            bf.next = s;
            bs.next = f;

            s.next = af;
            f.next = as;    
        }
        
        
        
        
        
    }
    
    
    
    
    
    
    
    
}