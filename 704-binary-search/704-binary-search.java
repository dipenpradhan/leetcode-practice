class Solution {
    public int search(int[] nums, int target) {
        if(nums == null || nums.length == 0) return -1;
        else if(nums.length == 1 && nums[0] == target) return 0;
        
        int left = 0, right = nums.length-1, mid = right/2;
        
        while(left <= right){
            mid = left + (right - left)/2;
            
            if(nums[mid] == target) return mid;
            
            if(target < nums[mid]){
                right = mid-1;
            }else{
                left = mid+1;
            }
            
        }
        return -1;
    }
}