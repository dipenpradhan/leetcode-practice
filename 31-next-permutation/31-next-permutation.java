class Solution {
    public void nextPermutation(int[] nums) {
        
        // Overall approach:
        // 1. Start from right (end of array)
        // 2. Find first non-asc number walking from end of array to start and call it n1
        // 3. We will have to swap this number to an index between the number's current position and the end of array
        // 4. The index we swap to will have be the next greatest number after this number
        // 5. After the swap, all numbers beyond the newly swapped position must be ascending - but we know for a fact that the order is in fact descending as per step #2
        // 6. Based on #2 & #6, we can reverse all the numbers after #2's index
        // 7. Edge case: if array is in descending order, next permutation is the entire array in ascending order
        
        // Step #2: Find the first non-asc number beginning from end of array and moving towards start
        // We record the position of this number as "numPos"
        int numPos = -1;
        for(int i = nums.length - 1; i > 0; i--){
            if(nums[i] > nums[i-1]){
                numPos = i-1;
                break;
            }
        }
        
        // Step #3-4: Find the next largest number after the number at numPos
        // We record the position of this number as "swapPos"
        // We look for this number only if numPos is not -1
        // If numPos == -1, it means the entire array is sorted in a descending order
        // and the next permutation will be the array in ascending order (reverse entire array)
        int swapPos = -1;
        if(numPos >= 0){
            for(int i = nums.length-1; i >= numPos; i--){
                if(nums[i] > nums[numPos] && (swapPos == -1 || nums[i] < nums[swapPos])){
                    // If we find a number that's greater than the number at numPos
                    // And the number is less than the number at existing swapPos
                    // (or if swapPos == -1 meaning no next greatest number has been recorded yet)
                    // We update swapPos with this number's position
                    swapPos = i;
                }
            }
            
        }
        
        // Step #4: If a valid swapPos was found, swap numPos with swapPos
        if(swapPos >= 0){
            swap(nums, numPos, swapPos);    
        }
        // Step #6-7: Reverse remaineder of array
        // If array was in descending order, then numPos will be -1, and we will reverse from numPos+1 = 0 onwards
        // Reverse remainder of array
        reverse(nums, numPos+1, nums.length-1);
        
    }
    
    // Helper function to swap
    private void swap(int[] nums, int pos1, int pos2){
        int num1 = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = num1;
    }
    
    // Helper function to reverse
    private void reverse(int[] nums, int start, int end){
        while(start < end){
            swap(nums, start, end);
            start++;
            end--;
        }
    }
}