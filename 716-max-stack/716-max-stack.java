class MaxStack {
    
    static final class DLL{
        DLLNode h,t;
        DLL(){
            h = new DLLNode(0);
            t = new DLLNode(0);
            h.nxt = t;
            t.pre = h;
        }
        void addHead(DLLNode n){
            n.pre = h;
            n.nxt = h.nxt;
            h.nxt.pre = n;
            h.nxt = n;
        }
        void remove(DLLNode n){
            n.pre.nxt = n.nxt;
            n.nxt.pre = n.pre;
        }
        DLLNode peekHead(){
            return h.nxt;
        }
        public String toString(){
            StringBuilder sb = new StringBuilder();
            DLLNode n = h;
            while(n!=null){
                sb.append(n);
                sb.append(" ");
                n = n.nxt;
            }
            return sb.toString();
        }
    }
    static final class DLLNode{
        int val;
        DLLNode pre;
        DLLNode nxt;
        DLLNode(int val){
            this.val = val;
        }
        public String toString(){
            return ""+val;
        }
    }
    
    DLL dll = new DLL();
    
    TreeMap<Integer, List<DLLNode>> map = new TreeMap<Integer, List<DLLNode>>((a,b)->a-b);
    
    public MaxStack() {
        
    }
    
    public void push(int x) {
        if(!map.containsKey(x)){
            map.put(x, new ArrayList<DLLNode>());
        }
        DLLNode n = new DLLNode(x);
        dll.addHead(n);
        map.get(x).add(n);
        // System.out.println("push(x) = "+x);
        // System.out.println(dll.toString());
        
    }
    
    public int pop() {
        DLLNode n = dll.peekHead();
        dll.remove(n);
        int s = map.get(n.val).size();
        if(s > 1){
           map.get(n.val).remove(s - 1); 
        }else{
            map.remove(n.val);
        }
        // System.out.println("pop() = "+n);
        return n.val;
    }
    
    public int top() {
        // System.out.println("top() = "+dll.peekHead());
        return dll.peekHead().val;
    }
    
    public int peekMax() {
        // System.out.println("peekMax() = "+map.lastKey());
        return map.lastKey();
    }
    
    public int popMax() {
        int m = peekMax();
        DLLNode n = map.get(m).get(map.get(m).size() - 1);
        dll.remove(n);
        
        int s = map.get(m).size();
        if(s > 1){
           map.get(m).remove(s - 1); 
        }else{
            map.remove(m);
        }
        
        // System.out.println("popMax() = "+m);
        return m;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */