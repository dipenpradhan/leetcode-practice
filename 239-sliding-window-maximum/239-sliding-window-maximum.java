class Solution {
    
    // [1  3  -1] -3  5  3  6  7   
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<Integer>(); // 3, -1
        List<Integer> res = new ArrayList<Integer>();
        
        for(int i = 0; i < nums.length; i++){ // i0 // 1 // 2 // 3
            int n = nums[i]; // n1 //3
            // window size reached
            if(i>=k){// i0>k3 F // F // F // T
                res.add(dq.peekFirst());
                if(nums[i-k] == dq.peekFirst()){
                    dq.pollFirst();
                }
            }
            
            // clear and add
            if(dq.size() == 0 || n > dq.peekFirst()){ // size 0
                dq.clear();
                dq.add(n);// 1 3
            }else if(n > dq.peekLast()){
                // poptail + append tail
                while(!dq.isEmpty() && n > dq.peekLast()){
                    dq.pollLast();
                }
                dq.addLast(n);
            }else{
                // append tail
                dq.addLast(n);
            }
            
            // System.out.println(dq);
        }
        res.add(dq.pollFirst());
        int[] result = new int[res.size()];
        for(int i = 0; i < res.size(); i++){
            result[i] = res.get(i);
        }
        
        return result;
    }
}