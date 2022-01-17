class Solution {
    
    
    /*
        Rules of a valid tree:
            1. all nodes are connected
            2. there are no cycles
        
        fn validTree(n, edges):
            add edges in both direction to adjList
            create visited set
            dfs(0, ...
            
            if dfs is successful visited size is n:
                graph is valid
            
        fn bool dfs(node, n, adjList, visited, parent
            
            if node visited FAIL
            else mark node visited
            
            result = true
            loop over neighbors:
                if not parent:
                    result &= dfs(neighbor, ...
            
            return result
            
            
    */
    public boolean validTree(int n, int[][] edges) {
        
        // 0 - 1,2,3
        // 1 - 0, 4
        // 2 - 0
        // 3 - 0
        // 4 - 1
        
        // 0 - 1
        // 1 - 0,2,3,4
        // 2 - 1,3
        // 3 - 1
        // 4 - 1
    
        Map<Integer,List<Integer>> adjList = buildAdjList(edges);
        Set<Integer> visited = new HashSet<Integer>();
        
        // System.out.println(adjList);
        
        return dfs(0, n, adjList, visited, null) && visited.size() == n;
        
        
    }
    
    private Map<Integer,List<Integer>> buildAdjList(int[][] edges){
        
        Map<Integer,List<Integer>> adjList = new HashMap<Integer,List<Integer>>();
        
        if(edges == null) return adjList;
        
        for(int[] edge: edges){
            
            if(!adjList.containsKey(edge[0])){
                adjList.put(edge[0], new ArrayList<Integer>());
            }
            if(!adjList.containsKey(edge[1])){
                adjList.put(edge[1], new ArrayList<Integer>());
            }
            
            adjList.get(edge[0]).add(edge[1]);
            adjList.get(edge[1]).add(edge[0]);
            
        }
        
        return adjList;
        
    }
    
    private boolean dfs(int node, int n, Map<Integer, List<Integer>> adjList, Set<Integer> visited, Integer parent){
        
        if(node < 0 || node >= n){
            return false;
        }
        
        if(visited.contains(node)){
            return false;
        }
        
        visited.add(node);
        
        if(!adjList.containsKey(node)){
            return true;
        }
        
        boolean result = true;
        
        for(int neighbor: adjList.get(node)){
            if(parent == null || neighbor != parent){
                result &= dfs(neighbor, n, adjList, visited, node);
            }
        }
        
        return result;
        
    }
    
    
}