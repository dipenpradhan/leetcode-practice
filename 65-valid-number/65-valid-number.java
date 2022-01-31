class Solution {
    public boolean isNumber(String s) {
        
        boolean digit = false, dot = false, exp = false;
        int N = s.length();
        int i = 0;
        while(i<N){
            char c = s.charAt(i);
            
            if(Character.isDigit(c)){
                digit = true;  
            }
            else if(c == '-' || c == '+'){

               if(i!=0 && s.charAt(i-1)!='E' && s.charAt(i-1)!='e') return false;
            }
            
            else if(c == '.') {
                if(dot || exp) return false;
                dot = true;
            }
            
            else if(c == 'e' || c == 'E'){
                if(!digit || exp) return false;
                digit= false;
                exp = true;
            }else{
                return false;
            }
            i++;
        }
        return digit;
    }
}