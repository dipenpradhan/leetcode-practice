class Solution {
    public int[] productExceptSelf(int[] nums) {
        // [1,2,3,4]  // input
        // [24,12,8,6] // expected result
        
        /*
            product except self:
                product of everything behind current number and everything after current number
                prefix * suffix
                prefix = product of all numbers before current
                suffix = product of all numbers after current
                
            N = nums length
            pf = [N] //prefix
            sf = [N] // suffix
            
            
            [1,2,3,4]
            prefix list:                                              suffix list:
                nums[0]: 1   pf: [],      product = 1    pf[0] = 1    sf: [2,3,4], product = 24   sf[0] = 24
                nums[1]: 2   pf: [1],     product = 1    pf[1] = 1    sf: [3,4],   product = 12   sf[1] = 12
                nums[2]: 3   pf: [1,2],   product = 2    pf[2] = 2    sf: [4],     product = 4    sf[2] = 4
                nums[3]: 4   pf: [1,2,3], product = 6    pf[3] = 6    sf: [],      product = 1    sf[3] = 1
                
            populate prefix and suffix
            populate result:
                result = prefix[i] * suffix[i]
                result = [1*24, 1*12, 2*4, 6*1]
                result = [24, 12, 8, 6]
                
        
        */
        
        
        int N = nums.length;
        int[] pf = new int[N];
        int[] sf = new int[N];
        int[] result = new int[N];
        
        for(int i = 0, j = N-1; i < N; i++, j--){
            
            if(i == 0){
                pf[i] = 1; // empty set prefix [] product is 1
                sf[j] = 1; // empty set suffix [] product is 1
            }else{
                pf[i] = nums[i-1] * pf[i-1]; // product of previous number and the prefix product at that index
                sf[j] = nums[j+1] * sf[j+1]; // product of next number and the suffix product at that index
            }
        }
        for(int i = 0; i < N; i++){
            result[i] = pf[i] * sf[i]; // Result is product of prefix and suffix
        }
        
        return result;
    }
}