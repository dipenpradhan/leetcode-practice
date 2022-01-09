class Solution {
    public int rob(int[] nums) {
        int N = nums.length;
        if(nums == null || N == 0) return 0;
        else if(N == 1) return nums[0];
        
        int[] memo_first = new int[N];
        int[] memo_nofirst = new int[N];
        
        memo_first[0] = nums[0];
        memo_first[1] = Math.max(memo_first[0], nums[1]);
        
        memo_nofirst[1] = nums[1];
        
        
        for(int i = 2; i < N; i++){
            
            if(i != N - 1){
                memo_first[i] = Math.max(memo_first[i - 2] + nums[i], memo_first[i - 1]);
            }
            
            memo_nofirst[i] = Math.max(memo_nofirst[i - 2] + nums[i], memo_nofirst[i - 1]);
            
        }
        
        return Math.max(memo_first[N-2], memo_nofirst[N-1]);
    }
}