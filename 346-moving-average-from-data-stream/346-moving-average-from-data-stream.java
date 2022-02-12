class MovingAverage {

    private Deque<Integer> dq = new ArrayDeque<Integer>();
    private int tot, s;
    public MovingAverage(int size) {
        this.s = size;
    }
    
    public double next(int val) {
        if(dq.size() >= s) tot-=dq.removeFirst();
        tot+=val;
        dq.add(val);
        return (double)tot/dq.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */