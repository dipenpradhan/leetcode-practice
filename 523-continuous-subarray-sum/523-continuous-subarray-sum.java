class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int s = 0;
        map.put(s, -1);
        
        for(int i = 0; i < nums.length; i++){
            int n = nums[i];
            s += n;
            s %= k;
            if(map.containsKey(s) && i - map.get(s) > 1 ){
                return true;
            }
            map.put(s, map.getOrDefault(s, i));
        }
        return false;
    }
}