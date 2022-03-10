class Solution {
    public void sortColors(int[] nums) {
        int l = 0, r = nums.length - 1, w = 0;
        
        while(w <= r){
            if(nums[w] == 0){
                swap(nums, w, l);
                l++;
                w++;
            }
            else if(nums[w]==2){
                swap(nums, w, r);
                r--;
            }else{
                w++;
            }
            
        }
    }
    
    
    private void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}