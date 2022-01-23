class LRUCache {

    static final class DLLNode{
        int key;
        int val;
        DLLNode nxt;
        DLLNode pre;
        DLLNode(int key, int val){
            this.key = key;
            this.val = val;
        }
        DLLNode(){
            
        }
    }
    
    int cap;
    DLLNode h, t;
    Map<Integer, DLLNode> map = new HashMap<Integer, DLLNode>();
    
    public LRUCache(int capacity) {
        this.cap = capacity;
        h = new DLLNode();
        t = new DLLNode();
        h.nxt = t;
        t.pre = h;
    }
    
    void add(DLLNode n){
        
        n.nxt = h.nxt;
        n.pre = h;
        h.nxt.pre = n;
        h.nxt = n;
        
    }
    
    void remove(DLLNode n){
        if(n == null || n.pre == null || n.nxt == null) return;
        n.pre.nxt = n.nxt;
        n.nxt.pre = n.pre;
    }
    
    public int get(int key) {
        // System.out.println("get("+key+")");
        if(!map.containsKey(key)) return -1;
        
        DLLNode n = map.get(key);
        remove(n);
        add(n);
        // debug();
        return map.get(key).val;
    }
    
    public void put(int key, int value) {
        // System.out.println("put("+key+","+value+")");
        
        DLLNode n = map.getOrDefault(key, null);
        
        if(n == null){
            n = new DLLNode(key, value);
            map.put(key, n);
        }else{
            n.val = value;
            remove(n);
        }
        add(n);
        
        if(map.size()>cap){
            int r = t.pre.key;
            remove(t.pre);
            map.remove(r);
        }
        
        
        // debug();
    }
    
    void debug(){
        DLLNode n = h;
        while(n!=null){
            System.out.print(n.val+" ");
            n = n.nxt;
        }
        System.out.println(map);
        System.out.println("");
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */