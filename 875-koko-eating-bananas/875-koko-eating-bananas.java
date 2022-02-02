class Solution {
    private static final int MIN=0, MAX=1, TOT=2;
    public int minEatingSpeed(int[] piles, int h) {
        int[] arr = minMaxTot(piles);
        
        return binS(piles, h, 1, arr[MAX]);
    }
    
    private int binS(int[] piles, int h, int l, int r){
        
        while(l<=r){
            int m = l + (r-l)/2;
            // System.out.println("l="+l+" m="+m+" r="+r);
            boolean mBan = eatBans(piles, m, h);
            if(mBan){
                r = m-1;
            }else{
                l = m+1;
            }
        }
        return l;
    }
    
    private boolean eatBans(int[] pls, int max, int hrs){
        
        int t = 0;
        for(int p: pls){
            t+=p/max;
            t+=(p%max)>0?1:0;
        }
        
        // System.out.println("t="+t);
        return t <= hrs;
    }
    private int[] minMaxTot(int[] p){
        int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, tot=0; 
        for(int b:p){
            min = Math.min(min, b);
            max = Math.max(max, b);
            tot+=b;
        }
        return new int[]{min, max, tot};
    }
}

/*

[30,11,23,4,20]
5
[3,6,7,11]
8
*/