class Solution {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        
        /*  
            fn allPaths(graph [][]):
                result = list<list>
                currPath = list
                dfs(0, result, currPath)

            fn dfs(node, result, currPath):
            
                for all next nodes:
                    add node to currPath
                    if(node is last n-1):
                        add currPath to result
                    else:
                        dfs
                    remove node from currPath
        */
        
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> currPath = new ArrayList<Integer>();
        currPath.add(0);
        dfs(0, graph, result, currPath);
        
        return result;
    }
    
    
    private void dfs(int node, int[][] graph, List<List<Integer>> result, List<Integer>currPath){
        
        int[] next = graph[node];
        
        for(int i = 0; i < next.length; i++){
            
            currPath.add(next[i]);
            
            if(next[i] == graph.length-1){
                result.add(new ArrayList<Integer>(currPath));
            }else{
                dfs(next[i], graph, result, currPath);
            }
            currPath.remove(currPath.size()-1);
        }


    }
    
}