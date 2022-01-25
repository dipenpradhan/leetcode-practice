/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/

/*
    h->t
    
    h-4-t
    h-2-4-t
    
*/

class Solution {
    
    Node h,t;
    
    void addHead(Node n){
        addAfter(h, n);
    }
    void addTail(Node n){
        addAfter(t.left, n);
    }
    void addAfter(Node a, Node n){
        n.left = a;
        n.right = a.right;
        a.right.left = n;
        a.right = n;
    }
    
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        h = new Node();
        t = new Node();
        h.right = t;
        t.left = h;
        
        dfs(root, h);
        
        h.right.left = t.left;
        t.left.right = h.right;
        
        return h.right;
    }
    
    void dfs(Node n, Node a){
        if(n == null) return;
        
        Node d = new Node(n.val);
        addAfter(a, d);
        dfs(n.left, d.left);
        dfs(n.right, d);
    }
    
}