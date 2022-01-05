class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums == null || nums.length < 3) return result;
        
        int i = 0, k = nums.length-1, j=i+1;
        Arrays.sort(nums);
        
        // for (int n : nums )System.out.print(n+" ");
        // System.out.println("");
        
        while(i < k-1){
            
            if(j == k || (i>0 && nums[i]==nums[i-1])){
                i++;
                j = i+1;
                k = nums.length - 1;
                continue;
            }
            if(j > i+1 && nums[j] == nums[j-1]){
                j++;
                continue;
            }
            
            if(j < k && k < nums.length - 1 && nums[k] == nums[k+1]){
                k--;
                continue;
            }
            int iNum = nums[i], jNum = nums[j], kNum = nums[k];
            
            if(iNum + jNum + kNum == 0){
                List<Integer> triplet = new ArrayList<Integer>();
                triplet.add(iNum);
                triplet.add(jNum);
                triplet.add(kNum);
                result.add(triplet);
                j++;
            }else if(iNum + jNum + kNum < 0){
                j++;
            }else{
                k--;
            }
                
        }
        
     return result;   
    }
}