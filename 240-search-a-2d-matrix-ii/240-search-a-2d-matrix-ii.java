class Solution {
    int ROWS, COLS;
    public boolean searchMatrix(int[][] matrix, int target) {
        ROWS = matrix.length;
        COLS = matrix[0].length;
        
        
        return search(matrix, target);
        
    }
    private boolean search(int[][] mat, int t){
        int r = ROWS - 1, c = 0;
        
        while(r >= 0 && c < COLS){
            if(t == mat[r][c]) return true;
            else if(t > mat[r][c]){
                c++;
            }else{
                r--;
            }
        }
        
        
        return false;
    }
    
}