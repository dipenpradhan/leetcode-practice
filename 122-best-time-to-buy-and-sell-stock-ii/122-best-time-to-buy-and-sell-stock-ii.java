class Solution {
    public int maxProfit(int[] prices) {
        int maxP = 0;
        
        for(int i = 0; i < prices.length-1; i++){
            int p = prices[i];
            int p2 = prices[i+1];
            
            if(p2 - p > 0){
                maxP += p2-p;   
            }
        }
        return maxP;
    }
}