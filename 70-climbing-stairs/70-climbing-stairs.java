class Solution {
    public int climbStairs(int n) {
        
        // If there are 0, 1 or 2 steps to take
        // then number of ways to take 0 steps is 0
        // only way to take 1 step is 1
        // ways to take 2 steps are 1 step +1 step or 2 steps at once (total 2 ways)
        if(n <= 2){
            return n;
        }
        
        // Initialize memo array for DP
        int[] memo = new int[n+1];
        
        
        for(int i = 0; i <= n; i++){
        
            if(i <= 2){
                // Set up base case - values for 0, 1 and 2 can be set based on the explanation above
                // No. of ways to climb 0, 1, or 2 steps is 0, 1 and 2
                memo[i] = i;
            }else{
                // For all steps from 3 onwards, there are 2 ways of climbing up to step "i"
                // Way 1: Climb 1 step from step "i-1"
                // Way 2: Climb 2 steps from step "i-2"
                // So total no. of ways to reach step "i" will be total no. of ways to reach total(i-1) + total(i-2)
                // Since we have already stored these results in the memo array, we add memo[i-1] + memo[i-2]
                // This fits the bottom-up dynamic programming concept for fibonacci series
                memo[i] = memo[i-1] + memo[i-2];    
            }   
        }
        
        // Return the number of possible ways at step "n" based on memo
        return memo[n];
    }
}