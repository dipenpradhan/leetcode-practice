class Solution {
    
    private static final int[][] DIRECTIONS = new int[][]{{-1,0},{1,0},{0,-1},{0,1}};
    private int totalCities;
    
    public int findCircleNum(int[][] isConnected) {
        //Examples:
        
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
        
        
        // The city-to-city relations are given in n x n matrix,
        // so the row and column count must match
        
        if(isConnected == null || isConnected.length == 0 || isConnected[0].length != isConnected.length) return -1;
        
        // Use totalCities count to check connections
        totalCities = isConnected.length;
        
        // visited array marks a visited city
        boolean[] visited = new boolean[totalCities];
        
        int provinceCount = 0;
        
        // Run DFS on each city
        // Inside the dfs function, we will check if the city was previously visited
        // Each call to the dfs function returns a count of provinces found at this location
        // and marks all other cities in the province visited
        for(int i = 0; i < totalCities; i++){
            provinceCount += dfs(isConnected, i, visited);    
        }
        
        return provinceCount;
    }
    
    private int dfs(int[][] isConnected, int n, boolean[] visited){
        
        // Check if city provided to this dfs call is a valid city index (city index must be >=0 and < totalCities)
        if(n < 0 || n >= totalCities || visited[n]) return 0;
        
        int count = 0;
        
        // Mark the current city we have reached using DFS as visited
        visited[n] = true;
        
        // For each city connection from the city "n"
        // check all 4 directions
        for(int i = 0; i < totalCities; i++){
            if(isConnected[n][i] == 1){
                count += dfs(isConnected, i, visited);
            } 
        }
        
        return 1;
    }
}