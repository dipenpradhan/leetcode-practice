class Solution {
    public void nextPermutation(int[] nums) {
        
        
        // start from right (end of array)
        // find first non-asc number walking from end of array to start and call it n1
        // we will have to swap this number to an index between the number's current position and the end of array
        // The index we swap to will be the next greatest number after this number
        // After the swap, all numbers beyond the newly swapped position must be ascending, if not, then
        int numPos = -1;
        
        for(int i = nums.length - 1; i > 0; i--){
            if(nums[i] > nums[i-1]){
                numPos = i-1;
                break;
            }
        }
        
        // System.out.println("nums["+numPos+"]="+nums[numPos]);
        int swapPos = -1;
        if(numPos>=0){
            for(int i = numPos; i < nums.length; i++){
                if(nums[i] > nums[numPos] && (swapPos == -1 || nums[i] < nums[swapPos])){
                    swapPos = i;
                }
            }
            
        }
        
        // swap number for next permutation
        if(swapPos>=0){
            swap(nums, numPos, swapPos);    
        }
        
        // sort remainder of array

        Arrays.sort(nums, numPos+1, nums.length);
    }
    
    private void swap(int[] nums, int pos1, int pos2){
        int num1 = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = num1;
    }
    
}