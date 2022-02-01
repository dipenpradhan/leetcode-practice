class Solution {
    public List<String> summaryRanges(int[] nums) {
        StringBuilder buf = new StringBuilder();
        List<String> res = new ArrayList<String>();
        int l = 0, r = 0;
        
        while(r<nums.length){
            
            if(r == nums.length-1 || (r<nums.length-1 && nums[r] + 1 != nums[r+1])){
                if(l==r){
                    res.add(""+nums[l]);
                }else{
                    res.add(nums[l]+"->"+nums[r]);
                }
                l=r;
                l++;
            }

            r++;
        }
        
        return res;
    }
}