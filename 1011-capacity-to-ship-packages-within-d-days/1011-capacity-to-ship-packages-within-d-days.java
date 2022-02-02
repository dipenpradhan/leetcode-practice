class Solution {
    private static final int MIN=0, MAX=1, TOT=2;

    public int shipWithinDays(int[] weights, int days) {
         int[] w = findMinMaxTotal(weights);

        return binSearch(weights, w[MAX], w[TOT], days);
    }
    
    private int binSearch(int[] wts, int l, int r, int d){
        while(l<=r){
          int m = l + (r-l)/2;
            

          int mDays = checkDays(wts, m);
          // System.out.println(l+" "+m+" "+r+" =>"+mDays);

          if(mDays == d && (l==m || checkDays(wts, m-1)>d)){
            return m;
          }else if(mDays > d){
              l = m+1;
          }else{
              r = m-1;     
          }
        }  
        return l;
    }
    
    private int checkDays(int[] wts, int cap){
        int d = 1, c = 0;
        for(int w: wts){
          c+=w;
          if(c>cap){
            d++;
            c=w;
          }
        }
                // System.out.println(d+" "+cap);

        return d;
    }
    private int[] findMinMaxTotal(int[] wts){

    int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, tot = 0;
    for(int w: wts){
      min = Math.min(min, w);
      max = Math.max(max, w);
      tot+=w;
    }
    return new int[]{min, max, tot};
    }
  
}