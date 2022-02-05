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
     public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> heap = new PriorityQueue<ListNode>((a,b)->a.val-b.val);
        ListNode res = new ListNode(-1);
        ListNode curr = res;
        for(ListNode n : lists){
            if(n!=null) heap.offer(n);
        }
        while(!heap.isEmpty()){
            ListNode n = heap.poll();
            if(n.next != null) heap.offer(n.next);  
            curr.next = n;
            curr = curr.next;
        }
         return res.next;
    }
    
}