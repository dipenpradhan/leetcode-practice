class Solution {
    public boolean isToeplitzMatrix(int[][] mat) {
        
        int ROWS = mat.length;
        int COLS = mat[0].length;
        
        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                int n = mat[r][c];
                if(r+1 < ROWS && c+1 < COLS && mat[r+1][c+1]!=n) return false;
            }
        }
        
        return true;
        
    }
}