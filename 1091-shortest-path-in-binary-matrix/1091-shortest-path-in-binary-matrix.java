class Solution {
    
    private static final int[][] DIRECTIONS = new int[][]{
        new int[]{1,1},new int[]{1,0}, new int[]{0,1},
        new int[]{-1,-1},new int[]{1,-1}, new int[]{-1,1},
         new int[]{-1,0},new int[]{0,-1}
    };
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int N = grid.length;
        boolean[][] visited = new boolean[N][N];
        Queue<int[]> q = new LinkedList<int[]>();
        q.offer(new int[]{0,0,1});
        while(!q.isEmpty()){
            
            int[] p = q.poll();
            int r = p[0], c = p[1], d = p[2];
            if(!visited[r][c]){
                visited[r][c] = true;
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
                    return d;
                }

            }
        }
        return -1;
    }
    
    
}