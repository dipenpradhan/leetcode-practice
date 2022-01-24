class MyLinkedList {

    static final class DLL{
        DLLNode h, t;
        DLL(){
            h = new DLLNode(-1);
            t = new DLLNode(-1);
            h.nxt = t;
            t.pre = h;
        }
        DLLNode get(int index){
            DLLNode n = h;
            for(int i = 0; i <= index; i++){
                n = n.nxt;
            }
            return n;
        }
        void addHead(DLLNode n){
            // n.pre = h;
            // n.nxt = h.nxt;
            // h.nxt.pre = n;
            // h.nxt = n;
            addAfter(h, n);
        }
        void addTail(DLLNode n){
            // n.pre = t.pre;
            // n.nxt = t;
            // t.pre.nxt = n;
            // t.pre = n;
            addAfter(t.pre, n);
        }
        void addAfter(DLLNode a, DLLNode n){
            n.pre = a;
            n.nxt = a.nxt;
            a.nxt.pre = n;
            a.nxt = n;
        }
        void remove(DLLNode n){
            if(n == null || n.pre == null || n.nxt == null) return;
            n.nxt.pre = n.pre;   
            n.pre.nxt = n.nxt;
        }
    }
    static final class DLLNode{
        DLLNode pre, nxt;
        int val;
        DLLNode(int val){
            this.val = val;
        }
    }
    
    DLL dll;
    public MyLinkedList() {
        dll = new DLL();
    }
    
    public int get(int index) {
        DLLNode n = dll.get(index);
        return n!=null?n.val:-1;
    }
    
    public void addAtHead(int val) {
        DLLNode n = new DLLNode(val);
        dll.addHead(n);
    }
    
    public void addAtTail(int val) {
        DLLNode n = new DLLNode(val);
        dll.addTail(n);
    }
    
    public void addAtIndex(int index, int val) {
        DLLNode n = dll.get(index);
        if(n == null) return;
        dll.addAfter(n.pre, new DLLNode(val));
    }
    
    public void deleteAtIndex(int index) {
        dll.remove(dll.get(index));
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */