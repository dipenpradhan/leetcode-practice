class Solution {
    public double myPow(double x, int n) {
       
        
        if(n == 0) return 1;
        else if(x == 0) return 0;
        
        
        double result = 1;
        double currVal = x;
        long pow = Math.abs((long)n);
        
        
        if(n < 0) currVal = 1/x;
        
        while(pow > 0){
            
            if(pow%2==1){
                result *= currVal;    
            }
            
            currVal *= currVal;
            pow /= 2;
            
        }
        
        return result;
          
    }
}