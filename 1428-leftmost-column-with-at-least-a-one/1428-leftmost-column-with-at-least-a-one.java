/**
 * // This is the BinaryMatrix's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface BinaryMatrix {
 *     public int get(int row, int col) {}
 *     public List<Integer> dimensions {}
 * };
 */

class Solution {
    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        
        int ROWS = binaryMatrix.dimensions().get(0);
        int COLS = binaryMatrix.dimensions().get(1);
        int min = Integer.MAX_VALUE;
        int c = COLS - 1;
        for(int r = 0; r<ROWS; r++){

            while(c>=0 && binaryMatrix.get(r,c) == 1){
                min = Math.min(min, c);
                c--;
            }
            if(c<0) return 0;

        }
        
        return min == Integer.MAX_VALUE ? -1 : min;
    }
}