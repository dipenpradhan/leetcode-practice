class Solution {
    int[][] DIRECTIONS = new int[][]{new int[]{-1,1}, new int[]{1,-1}};
    public int[] findDiagonalOrder(int[][] mat) {
        int ROWS = mat.length;
        if(ROWS == 0) return null;
        int COLS = mat[0].length;
        
        int i = 0, r = 0, c = 0;
        int[] res = new int[ROWS*COLS];
        int d = 0;
        while(i < res.length){
            // System.out.println("i="+i+" d="+d+" r="+r+" c="+c);
            // if( r < 0 || r >= ROWS || c < 0 || c >= COLS) break;
            // System.out.println("mat[r][c]="+mat[r][c]);
            
            res[i++] = mat[r][c];
            
            int rn = r + DIRECTIONS[d][0];
            int cn = c + DIRECTIONS[d][1];
            
            if( rn < 0 || rn >= ROWS || cn < 0 || cn >= COLS){
                
                if(d == 0){
                    int cp = c;
                    if(r==0 && c<COLS-1) c++;
                    if(cp == COLS-1 && r<ROWS-1) r++;
                    d = 1;
                }else{
                    int rp = r;
                    if(c==0 && r < ROWS-1) r++;
                    if(rp == ROWS-1 && c < COLS-1)c++;
                    d = 0;
                }
            }else{
                r = rn;
                c = cn;
            }
        }
        return res;
    }
}