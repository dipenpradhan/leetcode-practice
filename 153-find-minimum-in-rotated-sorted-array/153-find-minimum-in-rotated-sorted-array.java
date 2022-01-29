class Solution {
    public int findMin(int[] nums) {
        int l = 0, r = nums.length-1;
        
        while(l<=r){
            int m = l + (r-l)/2;
            
            
            // pivot on right
            if(nums[m] > nums[r]){
                l = m+1;
            }else // mid is pivot
            if(m == l || nums[m] < nums[m-1]){
                return nums[m];
            }
            
            else{
                r = m-1;
            }
        }
        return -1;
    }
}