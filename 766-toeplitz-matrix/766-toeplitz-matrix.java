class Solution {
    public boolean isToeplitzMatrix(int[][] mat) {
        
        int ROWS = mat.length;
        int COLS = mat[0].length;
        
        for(int r = 0; r < ROWS; r++){
            int c = 0;
            int n = mat[r][c];
            int rNxt = r;
            
            while(rNxt < ROWS-1 && c < COLS-1){
                if(mat[++rNxt][++c]!=n) return false;
            }
            
        }
        
        for(int c = 0; c < COLS; c++){
            int r = 0;
            int n = mat[r][c];
            int cNxt = c;
            
            while(r < ROWS-1 && cNxt < COLS-1){
                if(mat[++r][++cNxt]!=n) return false;
            }
        }
        return true;
        
    }
}