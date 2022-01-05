class Solution {
    public int[] twoSum(int[] numbers, int target) {
        
        // initialize a left and right pointer at beginning and end of array
        int left = 0, right = numbers.length - 1;
        
        // Sort the array. Since we don't have any requirements around input manipulation
        // we are sorting in-place
        Arrays.sort(numbers);
        
        while(left < right){
            
            int numLeft = numbers[left];
            int numRight = numbers[right];
            
            
            // If 2 valid numbers are found, return them
            if(numLeft + numRight == target){
                return new int[]{left+1, right+1};
            }else if(numLeft + numRight > target){
                // If number is greater than target
                // move right pointer leftwards
                // because array is sorted and largest numbers are to the right
                // and if we exceed target, we should look for smaller numbers
                right--;
            }else{
                // If number is less than target
                // move left pointer rightwards
                // because array is sorted and smallest numbers are to the left
                // and if we are not meeting target, we should look for larger numbers
                left++;
            }
            
        }
        // if nothing matches, return -1 as the location for both
        return new int[]{-1,-1};
    }
}