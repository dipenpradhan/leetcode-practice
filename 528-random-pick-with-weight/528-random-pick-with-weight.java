import java.util.*;
    
    
class Solution {
    private int sum = 0;
    private int[] prob,wts;
    public Solution(int[] wts) {
        this.wts = wts;
        prob = prob(wts);
    }
    
    int count = 0, curr = 0;
    
    public int pickIndex() {
        double val = sum * Math.random();
        return search(val);
    }
    
    private int search(double val){
        int l = 0, r = prob.length-1;
        
        while(l<=r){
            int m = l + (r-l)/2;
            
            if(val > prob[m]){
                l = m+1;
            }else{
                r = m-1;
            }
        }
        return l;
    }
    
    private int[] prob(int[] wts){
        int[] p = new int[wts.length];
        int c = 0;
        for(int i = 0; i < wts.length; i++){
            c += wts[i];
            p[i] = c;
        }
        sum = c;
        return p;
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