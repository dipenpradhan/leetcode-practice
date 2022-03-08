class Solution {
    public int[] nextGreaterElements(int[] nums) {
        
        Stack<Integer> stk = new Stack<Integer>();
        int[] res = new int[nums.length];
        for(int r = 0; r < res.length; r++){
            res[r] = -1;
        }
        boolean loop=false;
        int i = 0;
        while(!loop || i<nums.length){
            if(i==nums.length){
              loop = true;
              i = 0;  
            } 
            while(!stk.isEmpty() && nums[i] > nums[stk.peek()]){
                    res[stk.pop()] = nums[i];
            }
            if(res[i]==-1)
                stk.push(i);
            i++;
        }
     return res;   
    }
}