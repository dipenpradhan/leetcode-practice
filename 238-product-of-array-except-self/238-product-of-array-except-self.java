class Solution {
    public int[] productExceptSelf(int[] nums) {
        // [1,2,3,4]
        // [24,12,8,6]
        int N = nums.length;
        
        int[] pf = new int[N]; // prefix product
        int[] sf = new int[N]; // suffix product
        
        pf[0] = 1; // prefix at start of array is [], so set pf product to 1
        sf[N-1] = 1; // suffix at end of array is [], so set sf product to 1
        
        for(int i = 1, j = N-2; i < N; i++, j--){
            
            pf[i] = nums[i-1] * pf[i-1]; // at every index, calculate product for i from start until i-1 (prefix)
            sf[j] = nums[j+1] * sf[j+1]; // at every index, calculate product for j from end until j+1 (suffix)

        }
        // System.out.println("pf="+Arrays.toString(pf));
        // System.out.println("sf="+Arrays.toString(sf));
        int[] result = new int[N];
        
        for (int i = 0; i < N; i++){
            result[i] = pf[i] * sf[i]; // result is product of prefix and suffix at position "i"
        }
        
        return result;
    }
}