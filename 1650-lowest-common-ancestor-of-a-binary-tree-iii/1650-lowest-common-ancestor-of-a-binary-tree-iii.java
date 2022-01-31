/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node parent;
};
*/

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        
        // Node rp = dfs(p, q);
        // if(rp!=null) return rp;
        // Node rq = dfs(q, p);
        // if(rq!=null) return rq;
        Node pt = p, qt = q;
        
        Set<Node> set = new HashSet<Node>();
        while(pt!=null){
            if(set.contains(pt)) return pt;
            if(pt==q) return q;
            set.add(pt);
            pt = pt.parent;
        }
        
        while(qt!=null){
            if(set.contains(qt)) return qt;
            if(qt==p) return qt;
            set.add(qt);
            qt = qt.parent;
        }
        return null;
    }
    
    private Node dfs(Node n, Node s){
        if(n==null || s == null) return null;
        
        if(n == s) return n;
        
        Node l = dfs(n.left, s);
        if(l!=null) return l;
        Node r = dfs(n.right, s);
        if(r!=null) return r;
        
        return null;
        
    }
}