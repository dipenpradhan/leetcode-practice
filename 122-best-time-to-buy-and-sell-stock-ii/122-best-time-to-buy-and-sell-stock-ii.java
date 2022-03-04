class Solution {
    public int maxProfit(int[] prices) {
        int prof = 0, maxP = 0;
        
        for(int i = 0; i < prices.length; i++){
            int p = prices[i];
            int p2 = i+1<prices.length?prices[i+1]:0;
            
            if(i!=prices.length-1 && p2 - p > 0){
                prof += p2-p;   
            }else{
                maxP += prof;
                prof = 0;
            }
        }
        return maxP;
    }
}