class Solution {
    public int myAtoi(String s) {
        Pair<Integer,String> num = parseNum(s);
        if(num.getValue().length()==0) return 0;
        long res = 0;
        for(char c : num.getValue().toCharArray()){
            res*=10;
            res += num.getKey()*Character.getNumericValue(c);
            if(res >= Integer.MAX_VALUE){
                res = Integer.MAX_VALUE;  
                break;
            }else if (res <= Integer.MIN_VALUE){
                res = Integer.MIN_VALUE;
                break;
            }
        }
        
        return (int)res;
    }
    
    private Pair<Integer, String> parseNum(String s){
        int sign = 0;
        StringBuilder res = new StringBuilder();
        
        for(char c : s.toCharArray()){
            
            if(Character.isDigit(c)){
                sign = sign==0?1:sign;
                res.append(c);
            }else if(sign==0 && (c == '+' || c == '-')){
                sign = c == '+'? 1 : -1;
            }else if(sign!=0 || res.length() != 0 || c != ' '){
                break;
            }
            
        }
        
        return new Pair<Integer, String>(sign, res.toString());
    }
}