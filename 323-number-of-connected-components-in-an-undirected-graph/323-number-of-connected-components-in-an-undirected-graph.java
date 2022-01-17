class Solution {
    
    private int count = 0;
    
    public int countComponents(int n, int[][] edges) {
        // System.out.println("edges="+edges);
        boolean[] visited = new boolean[n];
        
        Map<Integer, List<Integer>> adjList = new HashMap<Integer, List<Integer>>();
        
        for(int[] edge: edges){
            if(!adjList.containsKey(edge[0])){
                adjList.put(edge[0], new ArrayList<Integer>());
            }
            adjList.get(edge[0]).add(edge[1]);
            if(!adjList.containsKey(edge[1])){
                adjList.put(edge[1], new ArrayList<Integer>());
            }
            adjList.get(edge[1]).add(edge[0]);
        }

        for(int i = 0; i < n; i++){
            if(!visited[i]){
                dfs(i, visited, n, adjList);
                count++;
            }
            
        }
        
        return count;
        
    }
    
    private void dfs(int node, boolean[] visited, int n, Map<Integer, List<Integer>> adjList){
        
        if(!visited[node]){
            visited[node] = true;
            
            if(adjList.containsKey(node)){
                for(int j : adjList.get(node)){
                    dfs(j, visited, n, adjList);
                }
            }
            
        }
        
        
    }
}