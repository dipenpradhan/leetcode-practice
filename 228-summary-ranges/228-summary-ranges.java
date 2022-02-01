class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        int l = 0, r = 0;
        StringBuilder buf = new StringBuilder();
        while(r<nums.length){
            
            if(r == nums.length-1 || (r<nums.length-1 && nums[r] + 1 != nums[r+1])){
                buf.setLength(0);
                if(l==r){
                    buf.append("");
                    buf.append(nums[l]);
                }else{
                    buf.append(nums[l]);
                    buf.append("->");
                    buf.append(nums[r]);
                }
                res.add(buf.toString());
                l=r;
                l++;
            }

            r++;
        }
        
        return res;
    }
}