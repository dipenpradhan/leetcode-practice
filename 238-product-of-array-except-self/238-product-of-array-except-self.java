class Solution {
    public int[] productExceptSelf(int[] nums) {
        // [1,2,3,4]
        // [24,12,8,6]
        int N = nums.length;
        int[] pf = new int[N];
        int[] sf = new int[N];
        pf[0] = 1;
        sf[N-1] = 1;
        
        for(int i = 1, j = N-2; i < N; i++, j--){
            
            pf[i] = nums[i-1] * pf[i-1];
            sf[j] = nums[j+1] * sf[j+1];

        }
        // System.out.println("pf="+Arrays.toString(pf));
        // System.out.println("sf="+Arrays.toString(sf));
        int[] result = new int[N];
        
        for (int i = 0; i < N; i++){
            
            result[i] = pf[i] * sf[i];
            
        }
        
        return result;
    }
}