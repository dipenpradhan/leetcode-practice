class Solution {
    public boolean validWordAbbreviation(String word, String abbr) {
        
        int a = 0, w = 0;
        StringBuilder buf = new StringBuilder();
        
        while(a < abbr.length() || w < word.length()){
            
            if(a<abbr.length() && Character.isDigit(abbr.charAt(a))){
                buf.append(abbr.charAt(a));
                a++;
            }else if(buf.length()>0){
                if(buf.charAt(0)=='0') return false;
                w += Integer.parseInt(buf.toString());
                buf.setLength(0);
            }else if( a < abbr.length() && w < word.length() && abbr.charAt(a) == word.charAt(w)){
                a++;
                w++;
            }else{
                return false;
            }
        }
        return buf.length()==0 && a == abbr.length() && w == word.length();
    }
}