class Solution {
    
    int rows, cols;
    int[][] DIRECTIONS = new int[][]{{0,1},{0,-1},{1,0},{-1,0}};
    
    public int largestIsland(int[][] grid) {
        if(grid == null) return 0;
        rows = grid.length;
        if(rows == 0 ) return 0;
        cols = grid[0].length;
        
        Map<String, Integer> sizes = new HashMap<String, Integer>();
        int max = 1;
        for(int r = 0; r < rows; r++){
            for(int c = 0; c < cols; c++){
                int g = grid[r][c];
                if(g != 1) continue;
                
                Set<String> border = new HashSet<String>();
                int res = dfs(grid, r, c, border);
                max = Math.max(res, max);
                for(String b : border){
                    sizes.put(b, sizes.getOrDefault(b, 1) + res);    
                }
            }
        }
        
        for(int v : sizes.values()){
            max = Math.max(v, max);
        }
        
        
        return max;
        
        
    }
    
    
    private int dfs(int[][] grid, int r, int c, Set<String> border){
        
        if(r < 0 || r >= rows ||c < 0 || c >= cols) return 0;

        int g = grid[r][c];
        
        if(g == 0){
            border.add(r+"|"+c);
            return 0;
        }
        
        if(g == 1){
            grid[r][c] = 2;
            int size = 1;
            
            for(int[] d : DIRECTIONS){
                size += dfs(grid, r+d[0], c+d[1], border);
            }
            return size;
        }
        return 0;
    }
}