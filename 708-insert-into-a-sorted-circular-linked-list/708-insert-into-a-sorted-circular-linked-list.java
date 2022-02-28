/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _next) {
        val = _val;
        next = _next;
    }
};
*/

class Solution {
    public Node insert(Node head, int insertVal) {
        if(head == null){
            Node res = new Node(insertVal);
            res.next = res;
            return res;
        }
        Node n = null;
        Node less = null;
        Node min = null;
        while(n!=head){
            if(n==null) n = head;
            
            if(insertVal > n.val){
                if(less == null || n.val >= less.val){
                    less = n;    
                }
                
            }
            if(min == null || min.val <= n.val){
                min = n;
            }
            n = n.next;
        }
        if(less==null){
            ins(min, insertVal);
        }else{
            ins(less, insertVal);
        }
        return head;
        
    }
    
    private void ins(Node n, int ins){
        n.next = new Node(ins, n.next);
    }
}