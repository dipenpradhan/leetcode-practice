class AllOne {

    TreeMap<Integer, Set<Node>> counts = new TreeMap<Integer, Set<Node>>((a,b)->a-b);
    Map<String, Node> map = new HashMap<String, Node>();
        
    static final class Node{
        int count = 1;
        String val;
        
        Node(String val){
            this.val = val;
        }
    }
    
    
    public AllOne() {
        
    }
    
    public void inc(String key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            counts.get(n.count).remove(n);
            
            if(counts.get(n.count).size() == 0){
                counts.remove(n.count);
            }
            
            n.count++;
             
            if(!counts.containsKey(n.count)){
                counts.put(n.count, new HashSet<Node>());
            }
            counts.get(n.count).add(n);
            
        }else{
            Node n = new Node(key);
            map.put(key, n);
            if(!counts.containsKey(n.count)){
                counts.put(n.count, new HashSet<Node>());
            }
            counts.get(n.count).add(n);
        }
    }
    
    public void dec(String key) {
        if(!map.containsKey(key)){
            return;
        }
        
        Node n = map.get(key);
        
        counts.get(n.count).remove(n);

        if(counts.get(n.count).size() == 0){
            counts.remove(n.count);
        }

        n.count--;
        if(n.count == 0){
            map.remove(key);
            return;
        }
        if(!counts.containsKey(n.count)){
            counts.put(n.count, new HashSet<Node>());
        }
        counts.get(n.count).add(n);

    }
    
    public String getMaxKey() {
        return counts.isEmpty() ? "":counts.get(counts.lastKey()).iterator().next().val;
    }
    
    public String getMinKey() {
        return counts.isEmpty() ? "":counts.get(counts.firstKey()).iterator().next().val;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */