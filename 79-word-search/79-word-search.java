class Solution {
    
    private static final int[][] DIRECTIONS = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    private int totalRows = 0, totalCols = 0;
    
    
    /*
        fn exist(board, word):
            visited array
            loop all rows:
                loop all cols:
                    result = backtrack(row, col, 0, ...
                    if(result) return true
            return false
        
        fn bool backtrack(row, col, start, visited
            
            if row, col exceed bounds:
                FAIL
            
            if row, col visited:
                FAIL
            
            mark row, col as visited
            
            result = true
            loop over all 4 directions
                result &= dfs(nextRow, nextCol, start+1,
            
            // backtrack step:
            mark row, col as not visited to enable recursion caller to explore the cell in another direction
            
            return result
        
    */
    
    public boolean exist(char[][] board, String word) {
        
        totalRows = board.length;
        
        if(board == null || totalRows <= 0) return false;
        
        totalCols = board[0].length;
        
        if(totalCols <= 0) return false;
        
        boolean[][] visited = new boolean[totalRows][totalCols];
        
        for(int r = 0; r < totalRows; r++){
            for(int c = 0; c < totalCols; c++){
                if(backtrack(r,c,0, visited, board, word)){
                    return true;
                }   
            }
        }
        return false;
    }
    
    private boolean backtrack(int row, int col, int start, boolean[][] visited, char[][] board, String word){

        if(start >= word.length()) return true;

        if(row < 0 || row >= totalRows || col < 0 || col >= totalCols || visited[row][col] || word.charAt(start) != board[row][col]){
            return false;
        }
        
        visited[row][col] = true;
        boolean result = false;
        for(int[] dir: DIRECTIONS){
            result |= backtrack(row + dir[0], col + dir[1], start+1, visited, board, word);
        }
        visited[row][col] = false;
        
        return result;

    }
}