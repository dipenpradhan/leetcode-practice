class Solution {
    public int findKthLargest(int[] nums, int k) {
        return qSel(nums, nums.length - k, 0, nums.length - 1);
    }
    
    private int qSel(int[] nums, int k, int l, int r){
        int pvt = nums[r];
        int sw = l;
        for(int i = l; i < r; i++){
            if(nums[i] < pvt){
                swap(nums, i, sw);
                sw++;
            }
        }
        swap(nums, r, sw);
        if(sw > k) return qSel(nums, k, l, sw-1);
        else if(sw < k) return qSel(nums, k, sw+1, r);
        else return nums[sw];
    }
    
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    
}