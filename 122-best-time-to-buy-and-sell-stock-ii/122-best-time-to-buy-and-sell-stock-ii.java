class Solution {
    public int maxProfit(int[] prices) {
        int maxP = 0;
        
        for(int i = 0; i < prices.length-1; i++){
            int p = prices[i];
            int p2 = i+1<prices.length?prices[i+1]:0;
            
            if(i!=prices.length-1 && p2 - p > 0){
                maxP += p2-p;   
            }
        }
        return maxP;
    }
}