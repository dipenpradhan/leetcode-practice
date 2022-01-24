class Solution {
    public void merge(int[] fst, int m, int[] sec, int n) {
        
        // 1,2,3,0,0,0 and 2,5,6
        
        int f = m - 1, s = n - 1, fe = m + n - 1;
        
        while(s >= 0){
            if(f >= 0){
                if(fst[f] > sec[s]){
                    fst[fe] = fst[f];
                    f--;
                }else{
                    fst[fe] = sec[s];
                    s--;
                }
            }else{
                fst[fe] = sec[s];
                s--;
            }
            
            fe--;
        }
        
    }
}