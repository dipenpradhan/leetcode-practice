class Solution {
    public int rob(int[] nums) {
        
        // Store total no. of houses as N for eas
        int N = nums.length;
        
        // If there are no houses, profit is 0
        if(nums == null || N == 0) return 0;
        // If there is only 1 house, profit is whatever robber gets from that house
        else if(N == 1) return nums[0];
        
        // Initialize memo arrays to store profit at each location when house 1 is selected (memo_first)
        // and when house 1 is not selected, allowing last house to be selected (memo_nofirst)
        int[] memo_first = new int[N];
        int[] memo_nofirst = new int[N];
        
        // If first house is selected, profit at house 0 will be nums[0]
        // and profit at house 1 will be a choice of selecting house 1 to rob and getting nums[1]
        // or else keeping profit from house 0 which was memo_first[0] and not robbing current house
        memo_first[0] = nums[0];
        memo_first[1] = Math.max(memo_first[0], nums[1]);
        
        
        // If first house is not selected, profit at house 0 will be 0
        // and profit at house 1 will be whatever robber gets from house 1
        memo_nofirst[1] = nums[1];
        
        for(int i = 2; i < N; i++){
            
            // If the house is not last house, check if picking current house "i" along with house "i-2" will give more profit
            // or if picking profit from "i-1" will be more
            if(i != N - 1){
                memo_first[i] = Math.max(memo_first[i - 2] + nums[i], memo_first[i - 1]);
            }
            
            // Do the same for when first house is not selected, going up to the n-th house at position (N-1) and allowing selection of last house
            memo_nofirst[i] = Math.max(memo_nofirst[i - 2] + nums[i], memo_nofirst[i - 1]);
            
        }
        
        // Return whichever series gives more profit bewteen
        // selecting first house and not allowing selection of last house (N-1 is not considered)
        // or not selecting first (memo_nofirst[0] = 0) and allowing last house (N-1) to be selected
        return Math.max(memo_first[N-2], memo_nofirst[N-1]);
    }
}