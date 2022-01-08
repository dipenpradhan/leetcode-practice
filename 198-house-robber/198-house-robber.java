class Solution {
    public int rob(int[] nums) {
        
        // If there are no houses, we have a profit of 0
        if(nums == null || nums.length == 0) return 0;
        // If there is only 1 house, we rob it and return the profit
        else if(nums.length == 1) return nums[0];
            
        // Initialize a memo array to store profit at each house
        int[] memo = new int[nums.length];
        
        // If we choose house 0 then profit is whatever we collect from it: nums[0]
        memo[0] = nums[0];
        // If we choose house 1 then profit is either profit from house 1 or house 0 whichever is greater
        memo[1] = Math.max(nums[0],nums[1]);
        
        // For every house check if profit at the current house plus house at i - 2
        // is greater than profit at house i - 1
        for(int i = 2; i < nums.length; i ++){
            memo[i] = Math.max(memo[i-2] + nums[i], memo[i-1]);
        }
        
        // Return the last profit value
        return memo[nums.length-1];
    }
}