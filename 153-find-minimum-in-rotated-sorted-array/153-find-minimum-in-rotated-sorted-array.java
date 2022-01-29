class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1;
        
        while(l<=r){
            int m = l + (r-l)/2;
            
            
            // pivot on right
            if(nums[m] > nums[r]){
                l = m+1;
            }else if(m == l || nums[m] < nums[m-1]){
                // mid is pivot
                return nums[m];
            }else{ // either pivot is on left or there is no pivot
                r = m-1;
            }
        }
        return -1;
    }
}