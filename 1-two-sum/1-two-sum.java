class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        // use hashmap to store the number as key and index as value
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        for(int i = 0; i < nums.length; i++){
            int n = nums[i];
            
            //for each number, look up the (target-n) value in the hashmap
            if(map.containsKey(target-n)){
                // if a complement number is found to current number "n", both together adding up to target
                // then return the pair of indices as result
                return new int[]{i, map.get(target - n)};
            }
            
            // put in number and index of number into hashmap
            map.put(n, i);
        }
        
        return null;
    }
}