class Solution {
    public int subarraySum(int[] nums, int k) {
        /*
            iterate through array and calculate all prefix sums
            starting from 0 -> i as we iterate through
            Example:
            [1,1,-1,1,1]
            
            hashmap sum -> count
            set count 1 for 0 because we can choose empty [] prefix subarray with 0 sum
            
            // the hashmap tells us all the prefix sums we can remove until this point
            // which means current (0 -> i sum) - (prefix) = k
            // rewriting (0 -> i sum) - k = prefix
            
            if prefix hashmap contains (0 -> i sum) - k
                count++
            
            update count of current prefix sum (0 -> i) in hashmap
            
        */
        
        // protect against bad input
        if(nums == null || nums.length == 0) return -1;
        
        Map<Integer, Integer> prefixSumCounts = new HashMap<Integer, Integer>();
        prefixSumCounts.put(0,1);
        
        int currSum = 0, count = 0;
        
        for(int i = 0; i < nums.length; i++){
            
            int num = nums[i];
            currSum += num;
            
            if(prefixSumCounts.containsKey(currSum - k)){
                count += prefixSumCounts.get(currSum - k);
            }
            
            if(prefixSumCounts.containsKey(currSum)){
                prefixSumCounts.put(currSum, prefixSumCounts.get(currSum) + 1);
            }else{
                prefixSumCounts.put(currSum, 1);
            }
        }
     return count;   
    }
}