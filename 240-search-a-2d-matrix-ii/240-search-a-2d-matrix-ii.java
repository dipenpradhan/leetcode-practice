class Solution {
    int ROWS, COLS;
    public boolean searchMatrix(int[][] matrix, int target) {
        ROWS = matrix.length;
        COLS = matrix[0].length;
        
        int[] row = findRow(matrix, target);
        if(row[0]<0 && row[1]<0)return false;
        row[0] = row[0]<0?matrix.length-1:row[0];
        row[1] = row[1]<0?0:row[1];
        // System.out.println(Arrays.toString(row));

        for(int r = row[1]; r <= row[0]; r++){
            if(findCol(matrix, r, target)>=0){
                return true;
            }
        }
        return false;
        
    }
    private int findCol(int[][] matrix, int row, int target){
        
        int l = 0, r = matrix[row].length-1;
        
        while(l<=r){
            int m = l + (r-l)/2;
            
            if(matrix[row][m] == target){
                return m;
            }else if(matrix[row][m]<target){
                l = m + 1;
            }else{
                r = m - 1;
            }
        }
        return -1;
        
    }
    private int[] findRow(int[][] mat, int t){
        
        int less = -1, great = -1;
        
        int s = 0, e = ROWS-1;
        
        while(s <= e){
            int m = s + (e-s)/2;
            int c = less < 0 ? 0 : COLS - 1;
            
            if(mat[m][c] <= t && (m==e || mat[m+1][c] > t)){
                if(less < 0){
                    less = m;
                    e = m;
                }else{
                    great = m;
                    return new int[]{less, great};
                }
            }else if(mat[m][c] > t){
                e = m-1;
            }else{
                s = m+1;
            }    
            
        }
        return new int[]{less, great};
    }
    
}