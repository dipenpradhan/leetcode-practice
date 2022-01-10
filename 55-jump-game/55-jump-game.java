class Solution {
    public boolean canJump(int[] nums) {
        
        // Approach:
        // We will iterate from right side of the array
        // At each location, we will check if the max jumped location from that point reaches the end of array
        // If reaching the end is possible from that location then mark it as yes and move leftwards
        
        // If array is empty or null then say false
        if(nums == null || nums.length == 0) return false;
        // If array has only 1 location then say true because a jump is not needed
        else if(nums.length==1) return true;
        
        // Initialize a memo array to hold jump validity at each index
        boolean[] memo = new boolean[nums.length];
        // Set up base case: last index of array is always true (it is already last, no jump needed)
        memo[nums.length-1] = true;
        
        
        for(int i = nums.length-2; i >= 0; i--){
            if(nums[i] > 0 && memo[i+1]) memo[i] = true;
            else{
                int start = i;
                while(start <= i+nums[i]){
                    if(memo[start]){
                        memo[i] = true;
                        break;
                    }
                    start++;
                }
            }
        }
        return memo[0];
        
    }
}