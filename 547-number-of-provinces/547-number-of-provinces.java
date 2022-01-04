class Solution {
    
    private static final int[][] DIRECTIONS = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    private int totalCities;
    
    public int findCircleNum(int[][] isConnected) {
        // [1 1 0]
        // [1 1 0]
        // [0 0 1]
        
        // [1 0 0]
        // [0 1 0]
        // [0 0 1]
        
        // [1 0 0 1]
        // [0 1 1 0]
        // [0 1 1 1]
        // [1 0 1 1]
        
        if(isConnected == null || isConnected.length == 0 || isConnected[0].length != isConnected.length) return -1;
        
        totalCities = isConnected.length;
        boolean[] visited = new boolean[totalCities];
        int provinceCount = 0;
        
        
        
        for(int i = 0; i < totalCities; i++){
            provinceCount += dfs(isConnected, i, visited);
            
        }
        
        return provinceCount;
    }
    
    private int dfs(int[][] isConnected, int n, boolean[] visited){
        
        if(n < 0 || n >= totalCities || visited[n]) return 0;
        int count = 0;
        
        visited[n] = true;
        
        
        for(int i = 0; i < totalCities; i++){
            if(isConnected[n][i] == 1){
                count++;  
                for(int[] dir:DIRECTIONS){
                    count += dfs(isConnected, i, visited);
                }
            } 
        
            
    
        }
        
        return 1;
    }
}