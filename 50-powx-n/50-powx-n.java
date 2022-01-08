class Solution {
    public double myPow(double x, int n) {
       
        // Any number to the power of 0 is 1
        if(n == 0) return 1;
        // Any power of 0 is 0
        else if(x == 0) return 0;
        
        // Initialize result to 1
        double result = 1;
        // Initialize result to 1
        double currVal = x;
        // Use long so that -2147483648 (-2^32) converts correctly to 2147483648 
        // Using int will cause an overflow because int capacity is only until 2147483647
        // Cast n to long to make sure we are calling Math.abs(long val) method signature
        long pow = Math.abs((long)n);
        
        // If we are finding negative exponent, set currVal to 1/x
        // x^-n is 1/x^n which means (1/x)*(1/x)*(1/x)....n number of times
        if(n < 0) currVal = 1/x;
        
        // From pow = absolute value of n, iterate down to 0, halving the value of pow each time
        // This halving gives us runtime of O(log n)
        while(pow > 0){
            
            // If value of pow is odd, multiply once more
            if(pow%2 == 1){
                result *= currVal;    
            }
            // We multiply the number with itself 
            // Exponent x^n is defined as x*x*x*x....n number of times
            // In each iteration we multiply the result by itself, and hence get x^2n each time
            // Example: 2^4 = 16
            // Iteration 1: currVal = 2*2 = 4, pow = 4
            // Iteration 2: currVal = 4*4 = 16, pow = 2
            // Iteration 3: currVal = 16*16 = 256, pow = 1
            // But we do not use currVal after iteration 3, we return "result" variable 
            // which is set to currVal before the 16*16 happens because pow == 1
            
            currVal *= currVal;
            pow /= 2;
            
        }
        
        return result;
          
    }
}