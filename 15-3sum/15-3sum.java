class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        // If the input is too short - less than 3 items
        // (i,j,k) cannot be identified, return empty list
        if(nums == null || nums.length < 3) return result;
        
        // initialise i to start of array, k to end of array
        // keep j one index after i, we will increment j until k-1
        // We try to find triplets at location i,j,k for each iteration
        int i = 0, k = nums.length-1, j = i+1;
        
        // Sort the array so that we can start iterating using
        // lowest and highest number in the array
        Arrays.sort(nums);
        
        // Iterate until i reaches end of array - 2 
        // because we want i, j and k to be distinct
        while(i < k-1){
            
            // If we finish checking all positions after i for triplets, j == k happens
            // If we run into a duplicate i, we do not want to use it
            // because duplicate i will cause duplicate triplets
            // We do not consider duplicates at i==0 because it might be a valid triplet
            // We increment i and we reset j to i+i and k to end of array
            // 
            if(j == k || (i>0 && nums[i]==nums[i-1])){
                i++;
                j = i+1;
                k = nums.length - 1;
                continue;
            }
            // if j is duplicate, increment j
            // j should not i+1, because then previous index is i
            if(j > i+1 && nums[j] == nums[j-1]){
                j++;
                continue;
            }
            // if k is duplicate, decrement k
            // k should be after j and behind the end of array
            if(j < k && k < nums.length - 1 && nums[k] == nums[k+1]){
                k--;
                continue;
            }

            // if we find a valid triplet, add it to result, and increment j
            if(nums[i] + nums[j] + nums[k] == 0){
                List<Integer> triplet = new ArrayList<Integer>();
                triplet.add(nums[i]);
                triplet.add(nums[j]);
                triplet.add(nums[k]);
                result.add(triplet);
                j++;
            }else if(nums[i] + nums[j] + nums[k] < 0){
                // if we find a triplet whose total is negative, 
                // increment j
                // because we want to go towards 0 (find a bigger nums[j] value)
                j++;
            }else{
                // if we find a triplet whose total is positive, 
                // decrement k
                // because we want to go towards 0 (find a smaller nums[k] value)
                k--;
            }
                
        }
        
     return result;   
    }
}