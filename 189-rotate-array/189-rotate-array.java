class Solution {
    public void rotate(int[] nums, int k) {
        // nums = [1,2,3,4,5,6,7,8,9,10], k = 3
        // Step 1: Reverse entire array
        // [10,9,8,7,6,5,4,3,2,1]
        // Step 2: Reverse first K elements
        // [8,9,10,7,6,5,4,3,2,1]
        // Step 3: Reverse remaining elements
        // [8,9,10,1,2,3,4,5,6,7]
        
        if(nums == null || nums.length <= 1){
            return;
        }
        
        // Take modulus of k to protect against case where k is greater than length of array
        k = k % nums.length;
        
        reverse(nums, 0, nums.length-1);
        reverse(nums, 0, k-1);
        reverse(nums, k, nums.length-1);
        
        // for(int n:nums){
        //     System.out.print(n+" ");
        // }
        
    }
    
    // Function to reverse part of array, inclusive of start and end index
    private void reverse(int[] arr, int start, int end){
        
        // Loop from start until we reach midpoint
        while(start < end){
            swap(arr, start, end);
            start++;
            end--;
        }
        
    }
    // Function to swap items at 2 positions i1 and i2 in array
    private void swap(int[] arr, int i1, int i2){
        int temp = arr[i1];
        arr[i1] = arr[i2];
        arr[i2] = temp;
    }
}