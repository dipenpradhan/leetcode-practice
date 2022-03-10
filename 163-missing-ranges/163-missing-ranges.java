class Solution {
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        
        List<String> rangeList = new ArrayList<String>();
        
        if(nums.length == 0){
            rangeList.add(buildPrettyString(lower, upper));    
            return rangeList;
        }
        
        
        for(int i = 0; i <= nums.length; i++){
            
            int num1 = 0;
            int num2 = 0;
            
            if(i == 0){
                num1 = lower-1;
            }else{
                num1 = nums[i-1];
            }
            
            if(i<nums.length){
                num2 = nums[i];
            }else{
                num2 = upper+1;
            }
            
            if( num1+1 <= num2-1){
                rangeList.add(buildPrettyString(num1+1, num2-1));
            }
            
        }
        
                
        return rangeList;
    }
    
    private String buildPrettyString(int range1, int range2){
        if(range1 == range2){
            return String.valueOf(range1);
        }else{
            return String.valueOf(range1)+"->"+String.valueOf(range2);
        }
    }
    
}