class Solution {
    public int maximumWealth(int[][] accounts) {
        int ROWS = accounts.length;
        if(ROWS == 0) return 0;
        int COLS = accounts[0].length;
        
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < ROWS; i++){
            int w = 0;
            for(int j = 0; j < COLS; j++){
                w += accounts[i][j];
            }
            max = Math.max(max, w);
            
        }
        return max;
    }
}