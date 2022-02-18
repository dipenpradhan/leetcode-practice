class Solution {
    public int myAtoi(String s) {
        
        return parseNum(s);
    }
    
    private int parseNum(String s){
        int sign = 0, res = 0;
        boolean seen = false;
        for(char c : s.toCharArray()){
            
            if(Character.isDigit(c)){
                if(!seen) seen = true;
                sign = sign==0?1:sign;
                if(sign<0 && res>=0) res = -res;
                
                if(sign>0 && res > Integer.MAX_VALUE/10 || (res == Integer.MAX_VALUE/10 && Character.getNumericValue(c)>7)){
                    return Integer.MAX_VALUE;
                }else if(sign<0 && res < Integer.MIN_VALUE/10 || (res == Integer.MIN_VALUE/10 && Character.getNumericValue(c)>8)){
                    return Integer.MIN_VALUE;
                }
                                                System.out.println("seen and res= "+res+" c="+Character.getNumericValue(c));

                res*=10;
                res += sign*Character.getNumericValue(c);

            }else if(sign==0 && (c == '+' || c == '-')){
                System.out.println("sign==0 and sign found "+c);
                sign = c == '+'? 1 : -1;
            }else if(sign!=0 || seen || c != ' '){
                break;
            }else{
                if(seen) break;
            }
            
        }
        
        return res;
    }
}
