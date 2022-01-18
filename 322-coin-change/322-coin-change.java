class Solution {
    public int coinChange(int[] coins, int amount) {
        
        //         0  1  2  3  4  5  6  7  8  9  10 11 
        //     1 | 0  1  2  2  3  3  2  3  3  4  4  3  
        //     2 | 0  12 1  2  2  3  3  2  3  3  4  4  
        //     5 | 0  12 12 12 12 1  2  2  3  3  2  3  
        //   MIN | 0  1  1  2  2  1  2  2  3  3  2  3  
        //
        // ANSWER = 3
        
        int[] memo = new int[amount+1];
        
        for(int i = 0; i < memo.length; i++){
            if(i == 0){
                memo[0] = 0;
            }else{
                memo[i] = amount + 1;
            }
            
        }
        
        
        for(int a = 1; a <= amount; a++){
            for(int c = 0; c < coins.length; c++){
                
                int coin = coins[c];
                
                if(a >= coin){
                    memo[a] = Math.min(memo[a], memo[a - coin] + 1);
                }
                
            }
            
            
        }
        
        return memo[amount] > amount ? -1 : memo[amount];
        
    }
}