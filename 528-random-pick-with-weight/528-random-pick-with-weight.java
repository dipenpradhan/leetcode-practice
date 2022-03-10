import java.util.*;
    
    
class Solution {
    private int sum = 0;
    private int[] prob,wts;
    public Solution(int[] wts) {
        this.wts = wts;
        
        sum = sum(wts);
        // prob = prob(wts, sum);
        
        prob = prob(wts, sum);
    }
    
    int count = 0, curr = 0;
    
    public int pickIndex() {
        int val = (int) Math.round(sum * Math.random());
        for(int i = 0; i < prob.length; i++){
            if(val < prob[i]){
                return i;
            }
        }
        return 0;
    }
    
    private int[] prob(int[] wts, int sum){
        int[] prob = new int[wts.length];
        int c = 0;
        for(int i = 0; i < wts.length; i++){
            c += wts[i];
            prob[i] = c;
        }
        return prob;
    }
    
    private int sum(int[] wts){
        int sum = 0;
        for(int w: wts){
            sum += w;
        }
        return sum;
    }
    
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */