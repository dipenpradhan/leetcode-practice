class Solution {
    public int[] sortArray(int[] nums) {
        
        mergeSort(nums);
        return nums;
        
    }
    
    void mergeSort(int[] nums){
        int N = nums.length;
        for(int s = 1; s < N; s*=2){
            for(int l = 0; l < N - s; l+=2*s){
                
                int m = l+s-1;
                int r = Math.min(l + 2*s - 1, N-1);
                
                merge(nums, l, m, r);
            }
            
        }
        
    }
    
    void merge(int[] nums, int l, int m, int r){
        int i = l, j = m+1, k = 0;
        int[] tmp = new int[r-l +1];
        
        while(i <= m || j <= r){
            
            if(i > m || (j<=r && nums[i]>nums[j])){
                tmp[k++] = nums[j++];
            }else{
                tmp[k++] = nums[i++];
            }
            
        }
        
        for(int p = 0; p < tmp.length; p++){
            nums[l+p] = tmp[p];
        }
        
    }
}