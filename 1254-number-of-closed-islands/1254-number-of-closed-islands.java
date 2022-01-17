class Solution {
    
    private static final int[][] DIRECTIONS = 
        new int[][]{
        {0,-1}, // left
        {0,1}, // right
        {-1,0}, // above
        {1,0} // below
    };
    
    private int totalRows, totalCols;
    
    public int closedIsland(int[][] grid) {
        
        totalRows = grid.length;
        totalCols = grid[0].length;
        
        if(grid == null || totalRows == 0 || totalCols == 0){
            return -1;
        }
        

        boolean[][] visited = new boolean[totalRows][totalCols];
        
        int count = 0;
        
        for(int r = 0; r < totalRows; r++){
            for(int c = 0; c < totalCols; c++){
                // start iterating over each non visited cell and check if it is surrounded by water using DFS
                if(grid[r][c] == 0 && !visited[r][c]){
                    if(dfs(r, c, visited, grid)){
                        count++;
                    }
                }
                
            }
        }
        
   
        return count;
    }
    /*
    [1,1,1,1,1,1,1,0],
    [1,0,0,0,0,1,1,0],
    [1,0,1,0,1,1,1,0],
    [1,0,0,0,0,1,0,1],
    [1,1,1,1,1,1,1,0]
    */
    /*
    0 [0,0,1,1,0,1,0,0,1,0],    [-,-,1,1,-,1,-,-,1,-],
    1 [1,1,0,1,1,0,1,1,1,0],    [1,1,*,1,1,-,1,1,1,-],
    2 [1,0,1,1,1,0,0,1,1,0],    [1,*,1,1,1,-,-,1,1,-],
    3 [0,1,1,0,0,0,0,1,0,1],    [-,1,1,-,-,-,-,1,*,1],
    4 [0,0,0,0,0,0,1,1,1,0],    [-,-,-,-,-,-,1,1,1,-],
    5 [0,1,0,1,0,1,0,1,1,1],    [-,1,-,1,-,1,-,1,1,1],
    6 [1,0,1,0,1,1,0,0,0,1],    [1,*,1,*,1,1,-,-,-,1],
    7 [1,1,1,1,1,1,0,0,0,0],    [1,1,1,1,1,1,-,-,-,-],
    8 [1,1,1,0,0,1,0,1,<0>,1],  [1,1,1,-,-,1,-,1,-,1],
    9 [1,1,1,0,1,1,0,1,1,0]     [1,1,1,-,1,1,-,1,1,-]
    */
    
    
    /*
    [1,1,1,1,1,1,1,0],      [1,1,1,1,1,1,1,-],
    [1,0,0,0,0,1,1,0],      [1,*,*,*,*,1,1,-],
    [1,0,1,0,1,1,1,0],      [1,*,1,*,1,1,1,-],
    [1,0,0,0,0,1,0,1],      [1,*,*,*,*,1,**,1],
    [1,1,1,1,1,1,1,0]       [1,1,1,1,1,1,1,0]
    */
    
    private boolean dfs(int row, int col, boolean[][] visited, int[][] grid){
        
        if(row < 0 || row >= totalRows || col < 0 || col >= totalCols) return false;
        
        if(visited[row][col] || grid[row][col] == 1){
            return true;
        }
        // System.out.println("dfs row="+row+" col="+col);
        visited[row][col] = true;
        
        boolean result = true;
        
        for(int[] dir : DIRECTIONS){
            result &= dfs(row + dir[0], col + dir[1], visited, grid);
        }
        
        return result;
        
        
    }
    
    
    
    
    
    
    
    
    
    
    
    
//     private boolean bfs(int[][] grid, boolean[][] visited, Queue<int[]> cellQ){
        
//         while(!cellQ.isEmpty()){
            
//             int[] cell = cellQ.poll();
//             int row = cell[0];
//             int col = cell[1];
//             // System.out.println("bfs row="+row+" col="+col);
//             if(row < 0 || row >= totalRows || col < 0 || col >= totalCols) return false;
            
//             if(!visited[row][col] && grid[row][col] == 0){
                
//                 visited[row][col] = true;
                
//                 for(int[] dir: DIRECTIONS){
//                     cellQ.offer(new int[]{row + dir[0], col + dir[1]});
//                 }
//             }else if (visited[row][col]  && grid[row][col] == 0){
//                 return false;
//             }
            
//         }
        
        
//         return true;
//     }
    
}