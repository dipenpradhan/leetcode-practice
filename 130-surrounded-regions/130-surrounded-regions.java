class Solution {
    private int ROWS, COLS;
    private static char X = 'X', O = 'O', V='_';
    private static int[][] DIR = 
        new int[][]{new int[]{0,1},
                new int[]{0,-1},
                new int[]{1,0},
                new int[]{-1,0}};
    
    public void solve(char[][] board) {
        ROWS = board.length;
        COLS = board[0].length;
        
        processEdges(board);
        change(board, O, X);
        change(board, V, O);
    }
    
    private void change(char[][] board, char in, char out){
        for(int r = 0; r < ROWS; r++){
            for(int c = 0; c < COLS; c++){
                if(board[r][c] == in){
                    board[r][c] = out;
                }
            }
        }
    }
        
    private void processEdges(char[][] board){
        for(int r = 0; r < ROWS; r++){
            dfs(board, r, 0, V);
            dfs(board, r, COLS-1, V);
        }
        for(int c = 1; c < COLS-1; c++){
            dfs(board, 0, c, V);
            dfs(board, ROWS-1, c, V);
        }
    }
    
    private void dfs(char[][] board, int r, int c, char rep){
        if(r < 0 || r >= ROWS || c < 0 || c >= COLS) return;
        // System.out.println(r+","+c);
        if(board[r][c] == O){
            // System.out.println(r+","+c+" == O");
            board[r][c] = rep;
            for(int[] d: DIR){
                dfs(board, r+d[0], c+d[1], rep);
            }
        }
    }
}
// ["X","X","X","X"],
// ["X","O","O","X"],
// ["X","X","O","X"],
// ["X","O","X","X"]]



/*

["X","_","_","X","X","X","O","X","_","_"],["X","_","X","X","X","X","X","X","X","X"],["X","X","X","X","O","X","X","X","X","X"],["X","O","X","X","X","O","X","X","X","_"],["_","X","X","X","O","X","O","X","O","X"],["X","X","O","X","X","O","O","X","X","X"],["_","X","X","O","O","X","O","X","X","_"],["_","X","X","X","X","X","O","X","X","X"],["X","O","O","X","X","O","X","X","O","_"],["X","X","X","_","_","X","_","X","X","_"]]
*/
/*
[["X","_","_","X","X","X","_","X","_","_"],["X","O","X","X","X","X","X","X","X","X"],["X","X","X","X","O","X","X","X","X","X"],["X","O","X","X","X","O","X","X","X","_"],["_","X","X","X","O","X","O","X","O","X"],["X","X","O","X","X","O","O","X","X","X"],["_","X","X","O","O","X","O","X","X","_"],["_","X","X","X","X","X","O","X","X","X"],["X","O","O","X","X","O","X","X","_","_"],["X","X","X","_","_","X","_","X","X","_"]]
*/