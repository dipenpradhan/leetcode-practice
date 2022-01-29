class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        int ROWS = matrix.length, COLS = matrix[0].length;
        int r = ROWS-1, c = 0;
        
        while(r >= 0 && c < COLS){
            if(target == matrix[r][c]){
                return true;
            }else if(target > matrix[r][c]){
                c++;
            }else{
                r--;
            }
        }
        return false;
    }
}


/*
// BINARY SEARCH

class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        
        if(matrix == null) return false;
        
        int row = findRow(matrix, target);
        return findCol(matrix, row, target)!=-1;
    }
    
    
    
    private int findRow(int[][] mat, int t){
        
        int s = 0, e = mat.length-1;
        
        while(s <= e){
            int m = s + (e-s)/2;
            
            if(mat[m][0] == t){
                return m;
            }else if(mat[m][0] < t && (m == mat.length-1 || mat[m+1][0] > t)){
                return m;
            }else if(mat[m][0] < t){
                s = m+1;
            }else{
                e = m-1;
            }
        }
        
        return -1;
        
    }
    
    
    private int findCol(int[][] mat, int row, int t){
        
        if(row < 0 || row >= mat.length) return -1;
        
        int l = 0, r = mat[row].length-1;
        
        while(l<=r){
            int m = l + (r-l)/2;
            
            if(mat[row][m] == t) return m;
            else if(mat[row][m] < t){
                l = m + 1;
            }else{
                r = m - 1;
            }
        }
        return -1;
    }
}
*/