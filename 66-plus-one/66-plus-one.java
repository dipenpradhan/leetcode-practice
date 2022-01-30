class Solution {
    public int[] plusOne(int[] digits) {
        
        int N = digits.length;
        int c = 0;
        int[] res = new int[N];
        
        for(int i = N-1; i>=0; i--){
            int d = digits[i];
            if(i==N-1)d++;
            d += c;
            c = d/10;
            d = d%10;
            res[i]=d;
        }
        if(c>0){
            int[] tmp = res;
            res = new int[N+1];
            res[0] = c;
            for(int i = 1; i < tmp.length; i++){
                res[i] = tmp[i];
            }
        }
        return res;
    }
}