class Solution {
    
    private static final int START = 0, END = 1;
    
    public int[] searchRange(int[] nums, int target) {
        
        int[] result = new int[2];
        // find first location of target
        result[START] = binarySearch(nums, target, START);
        
        // if first location is not found, do not check last location
        if(result[START] == -1) result[END] = -1;
        // if first location is found, find last location of target
        else result[END] = binarySearch(nums, target, END);
        
        return result;
    }
    
    private int binarySearch(int[] nums, int target, int position){
        
        int left = 0, right = nums.length - 1, mid;
        
        while(left <= right){
            
            mid = left + (right - left) / 2;
            
            // if we are finding first location of target, look for a situation where
            // mid is target and previous number before mid is not target
            // also check if mid has hit the start of array
            if(position == START){
                
                if(nums[mid] == target && (mid == left || nums[mid-1] != target)){
                    return mid;
                }else if(nums[mid] >= target){
                    // if mid is equal to target or greater than target,
                    // then continue searching in left half
                    // (we expect to find starting location of target in left half)
                    right = mid - 1;
                }else{
                    // if mid is greater than target,
                    // then continue searching in right half
                    left = mid + 1;
                }
                
            }else if (position == END){
            // if we are finding last location of target, look for a situation where
            // mid is target and next number after mid is not target
            // also check if mid has hit the end of array
                
                if(nums[mid] == target && (mid == right || nums[mid+1] != target)){
                    return mid;
                }else if(nums[mid] <= target){
                    // if mid is equal to target or less than target,
                    // then continue searching in right half
                    // (we expect to find starting location of target in right half)
                    left = mid + 1;
                }else{
                    // if mid is greater than target,
                    // then continue searching in left half
                    right = mid - 1;
                }
                
            }
            
        }
        return -1;
    }
    
}