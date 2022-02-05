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
        ListNode[] ptList = buildPtList( lists);
        ListNode res = new ListNode(-1);
        ListNode curr = res;
        
        while(true){
            ListNode n = findMin(ptList);
            if(n==null) return res.next;
            curr.next = n;
            curr = curr.next;
        }
        
    }
    
    private ListNode findMin(ListNode[] ptList){
        int min = Integer.MAX_VALUE, m = -1;
        for(int i = 0; i < ptList.length; i++){
            ListNode pt = ptList[i];
            // System.out.println("ptList["+i+"]="+(ptList[i]==null?"null":pt.val));
            if(pt!=null && pt.val<=min){
                m = i;
                min = pt.val;
            }
        }
        if(m==-1) return null;
        
        ListNode minNode = ptList[m];
        ptList[m] = ptList[m].next;
        // System.out.println("min="+minNode.val);

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