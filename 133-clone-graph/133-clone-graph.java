/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        
        // Create a HashMap of visited nodes
        // use node value as key and node reference as value
        Map<Integer, Node> seen = new HashMap<Integer, Node>();
       
        return clone(node, seen);
        
    }
    
    private Node clone(Node node, Map<Integer, Node> seen){
        
        if(node == null) {
            ////// System.out.println("node null, returned null");
            return null;
        }
        
        Node clone;
        
        
        // If node has not been previously seen, create a new node and put it into HashMap
        if(!seen.containsKey(node.val)){
            ////// System.out.println("node "+node.val+" added to seen hashmap");
             clone = new Node(node.val);
             seen.put(clone.val, clone);
        }else{
            // If node has been previously seen, return clone node reference (new node previously created above)
            ////// System.out.println("node "+node.val+" found in seen hashmap, returned null");
            return seen.get(node.val);
        }
        
        
        // if node has no neighbors return cloned node reference (the newly created cloned node)
        if(node.neighbors == null || node.neighbors.size() == 0){
            ////// System.out.println("node "+node.val+" has no neighbors, returning clone");
            return clone;
        }else{
            // if node has neighbors, create clones of neighbors recursively
            // This is a DFS approach that traverses all the way down the graph and fully populates neighbor lists
            // before returning a reference to clone
            clone.neighbors = new ArrayList<Node>();
            // System.out.println("node "+node.val+" has "+node.neighbors.size()+" neighbors, adding neighbors");
            
            for(Node n : node.neighbors){
                // for every neighbor, run same clone function and add each newly created child to neighbors list
                // NOTE - when the child is added, each child has a fully complete neighbors list since this executes in a depth-first manner
                Node childClone = clone(n, seen);
                if(childClone!=null){
                    clone.neighbors.add(childClone);    
                }
                
            }
        }
        
        return clone;
    }
    
}