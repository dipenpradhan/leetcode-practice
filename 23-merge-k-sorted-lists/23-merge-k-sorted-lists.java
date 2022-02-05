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
    
//     public ListNode mergeKLists(ListNode[] lists) {
//         ListNode[] ptList = buildPtList( lists);
//         ListNode res = new ListNode(-1);
//         ListNode curr = res;
        
//         while(true){
//             ListNode n = findMin(ptList);
//             if(n==null) return res.next;
//             curr.next = n;
//             curr = curr.next;
//         }
        
//     }
    
    private ListNode findMin(ListNode[] ptList){
        int min = Integer.MAX_VALUE, m = -1;
        for(int i = 0; i < ptList.length; i++){
            ListNode pt = ptList[i];
            if(pt!=null && pt.val<=min){
                m = i;
                min = pt.val;
            }
        }
        if(m==-1) return null;
        
        ListNode minNode = ptList[m];
        ptList[m] = ptList[m].next;

        return minNode;
    }
    
    private ListNode[] buildPtList(ListNode[] lists){
        ListNode[] ptList = new ListNode[lists.length];
        
        for(int i = 0; i < lists.length; i ++){
            ListNode n = lists[i];
            ptList[i] = n;
        }
        return ptList;
    }
}