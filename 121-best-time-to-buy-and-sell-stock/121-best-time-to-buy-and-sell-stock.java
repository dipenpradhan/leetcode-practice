class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, ans = 0;
        
        for(int i = 0; i < prices.length; i++){
            
            int p = prices[i];
            
            min = Math.min(min, p);
            
            ans = Math.max(ans, p - min);
            
        }
        return ans;
    }
}