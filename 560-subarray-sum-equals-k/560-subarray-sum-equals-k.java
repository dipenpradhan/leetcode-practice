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
        
        int s = 0, c = 0;
        Map<Integer, Integer> pfx = new HashMap<Integer, Integer>();
        pfx.put(s,1);
        
        for(int n : nums){
            s += n;
            c += pfx.getOrDefault(s-k, 0);
            pfx.put(s, pfx.getOrDefault(s, 0)+1);
        }
        
        return c;
    }
}