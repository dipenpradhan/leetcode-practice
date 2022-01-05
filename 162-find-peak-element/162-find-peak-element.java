class Solution {
    public int findPeakElement(int[] nums) {
        if(nums == null || nums.length == 0) return -1;
        else if(nums.length == 1) return 0;
        
        int left = 0, right = nums.length - 1, mid;
        
        while(left <= right){
            
            mid = left + (right - left) / 2;
            
            // elements outside array at start and end are -infinity
            
            // if mid is falling on an increasing path
            // mid+1 will be greater than mid OR mid is at end of array
            if(mid != right && nums[mid] < nums[mid+1]){
                // explore right side because peak has to be on the increasing side (right side)
                left = mid + 1;
            }else if(mid != left && nums[mid] < nums[mid-1]){
                // if mid is falling on a decreasing path
            // mid-1 will be greater than mid OR mid is at start of array
                // explore left side because peak has to be on the increasing side (left side)
                right = mid - 1;
            }else{
                // we will eventually reach a single element which is mid
                // OR we will reach a situation where mid is not less than the neighbors, so return mid
                // OR we will hit the end of the array (mid is at start or end), so return mid
                return mid;
            }
        }
        
        return -1;
        
        
    }
}