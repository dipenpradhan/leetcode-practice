class Solution {
    
    private static final int[][] DIRECTIONS = new int[][]{
        new int[]{1,1},new int[]{1,0}, new int[]{0,1},
        new int[]{-1,-1},new int[]{1,-1}, new int[]{-1,1},
         new int[]{-1,0},new int[]{0,-1}
    };
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int N = grid.length;
        Set<String> visited = new HashSet<>();
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[]{0,0,1});
        int min = Integer.MAX_VALUE;
        while(!q.isEmpty()){
            
            int[] p = q.poll();
            int r = p[0], c = p[1], d = p[2];
            if(!visited.contains(r+"|"+c)){
                visited.add(r+"|"+c);
            }else{
                continue;
            }
            if(grid[r][c]==0){
                for(int[] dir: DIRECTIONS){
                    int rn = r+dir[0];
                    int cn = c+dir[1];
                    if(rn>=0 && cn>=0 && rn<N && cn<N)
                        q.offer(new int[]{rn, cn, d+1});
                }
                if(r==N-1 && c==N-1) {
                    min = Math.min(min, d);
                }

            }
        }
        return min==Integer.MAX_VALUE?-1:min;
    }
    
    
}