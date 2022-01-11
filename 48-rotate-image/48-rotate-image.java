class Solution {
    public void rotate(int[][] matrix) {
        
        // Check if image matrix is valid
        if(matrix == null || matrix.length == 0) return;
        
        // To rotate an image, we apply 2 matrix operations:
        // Step 1: Transpose
        // Step 2: Mirror
        
        transpose(matrix);
        mirror(matrix);
        
    }
    
    private void transpose(int[][] matrix){
        
        // Transpose operation: swap cells between row and col
        // Do not visit previously swapped cells (initialize c = r)
        for(int r = 0; r < matrix.length; r++){
            for(int c = r; c < matrix[r].length; c++){
                int temp = matrix[r][c];
                matrix[r][c]= matrix[c][r];
                matrix[c][r] = temp;
            }
        }
    }
    
    
    private void mirror(int[][] matrix){
        
        // Mirror operation: iterate through each row, and swap columns till vertical center
        // this will flip the 2D matrix along vertical axis
        for(int r = 0; r < matrix.length; r++){
            for(int c = 0; c < matrix[r].length/2; c++){
                int temp = matrix[r][c];
                matrix[r][c] = matrix[r][matrix[r].length-c-1];
                matrix[r][matrix[r].length-c-1] = temp;
            }
        }
    }
    
}