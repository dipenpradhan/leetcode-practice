class Solution {
    public boolean areNumbersAscending(String s) {
        
        int max = 0, res = 0, f = 1;
        char[] ca = s.toCharArray();
        for(int i = 0; i <= ca.length; i++){
            char c = i<ca.length ? ca[i] : ' ';
            // System.out.println(c);
            if(c>='0' && c<='9'){
                res+= res*f + c-'0';
                f*=10;    
            }else{
                // System.out.println("checking "+res+" <= "+max);
                if(f>1 && res <= max) return false;
                max = Math.max(max, res);
                f = 1;
                res = 0;
            }
        }
        return true;
    }
}