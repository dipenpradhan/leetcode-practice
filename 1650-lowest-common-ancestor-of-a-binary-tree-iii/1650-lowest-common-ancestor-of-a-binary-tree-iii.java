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
 
}