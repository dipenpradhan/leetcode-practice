class Solution {
    
    
    private static int PACIFIC = 1, ATLANTIC = 2, BOTH = 3;
    private static enum ITER_DIR{ROWS, COLS};
    private static final int[][] DIRECTIONS = new int[][]{{0,1}, {0,-1}, {1,0}, {-1,0}};
    private int totalRows, totalCols;
    
    // [[1,2,2,3,5],[3,2,3,4,4],[2,4,5,3,1],[6,7,1,4,5],[5,1,1,2,4]]
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        // heights array is invalid, return null
        if(heights == null || heights.length == 0 || heights[0].length == 0) return null;
        
        // Set totalRows and totalCols value for convenience
        totalRows = heights.length;
        totalCols = heights[0].length;
        
        // Initialize an array to hold currently known ocean flow directions
        int[][] oceanFlow = new int[heights.length][heights[0].length];
        
        // for(EDGES edge : EDGES.values()){
        //     bfsOceanEdge(heights, oceanFlow, edge);
        // }
        
        for(int i = 0; i<4;i++){
            int[] dir = DIRECTIONS[i];
            switch(i){
                case 0: bfsOceanEdge(heights, oceanFlow, ITER_DIR.ROWS, 0, PACIFIC); break;
                case 1: bfsOceanEdge(heights, oceanFlow, ITER_DIR.ROWS, totalCols-1, ATLANTIC); break;
                case 2: bfsOceanEdge(heights, oceanFlow, ITER_DIR.COLS, 0, PACIFIC); break;
                case 3: bfsOceanEdge(heights, oceanFlow, ITER_DIR.COLS, totalRows-1, ATLANTIC); break;
            }
            
        }
        // debugPrint(oceanFlow);
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        for(int r = 0; r < totalRows; r++){
            for(int c = 0; c < totalCols; c++){
                if(oceanFlow[r][c] == BOTH){
                    List<Integer> cell = new ArrayList<Integer>();
                    cell.add(r);
                    cell.add(c);
                    result.add(cell);
                }
                
            }
            
        }
        return result;
        
    }
    
    
    private void bfsOceanEdge(int[][] heights, int[][] oceanFlow, ITER_DIR iterDir, int index, int ocean){
        
        
        Queue<int[]> islandQ = new LinkedList<int[]>();
        
        
        if(iterDir == ITER_DIR.ROWS){
            for(int r = 0; r < totalRows; r++){
                if(oceanFlow[r][index]==0) oceanFlow[r][index] = ocean;
                else if(oceanFlow[r][index]!=ocean)oceanFlow[r][index] = BOTH;
                islandQ.offer(new int[]{r, index});
            }
        }else if(iterDir == ITER_DIR.COLS){
            for(int c = 0; c < totalCols; c++){
                if(oceanFlow[index][c]==0) oceanFlow[index][c]  = ocean;
                else if(oceanFlow[index][c]!=ocean)oceanFlow[index][c] = BOTH;
                islandQ.offer(new int[]{index, c});
            }
        }
        
        while(!islandQ.isEmpty()){
            int[] pos = islandQ.poll();
            
            for(int[] dir:DIRECTIONS){
                int[] nextDir = new int[]{pos[0]+dir[0], pos[1]+dir[1]};
                boolean flowSuccess = visit(heights, oceanFlow, nextDir[0], nextDir[1], ocean, heights[pos[0]][pos[1]]);
                
                if(flowSuccess){
                    islandQ.offer(nextDir);
                }  
            }
        }
        
        
    }
    
    private boolean visit(int[][] heights, int[][] oceanFlow, int row, int col, int ocean, int height){
        
        if(row < 0 || row >= totalRows || col < 0 || col >= totalCols) return false;
        
        if(heights[row][col] >= height ){
        
            if(oceanFlow[row][col] != ocean && oceanFlow[row][col] != BOTH){
         
                if(oceanFlow[row][col] == 0){
                    oceanFlow[row][col] = ocean;
                    return true;
                }else{
                    oceanFlow[row][col] = BOTH;
                    return true;
                }

            }
            
        }
        
        return false;
        
    }
    
    private void debugPrint(int[][] arr){
        for(int i = 0; i < arr[0].length; i++){
            for(int j = 0; j < arr.length; j++){                
                System.out.print(" arr["+i+"]["+j+"]="+arr[i][j]);
            }
            System.out.println();
        }

    }
}