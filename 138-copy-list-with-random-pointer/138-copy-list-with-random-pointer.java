/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> map = new HashMap<Node, Node>();
        
        Node n = head;
        
        Node dummy = new Node(-1);
        Node res = dummy;
        
        while(n!=null){
            
            res.next = new Node(n.val);
            res.next.random = n.random;
            map.put(n, res.next);
            res = res.next;
            
            n = n.next;
        }
        
        for(Node v : map.values()){
            if(v.random == null) continue;
            v.random = map.get(v.random);
        }
        return dummy.next;
    }
}