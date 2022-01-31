class Solution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        StringBuilder buf = new StringBuilder();
        
        for(int i = s.length()-1; i>=0; i--){ // scan from right
            char c = s.charAt(i);
            
            if(c!=' '){
                buf.append(c);
                continue;
            }
            appendBuf(res, buf);
        }
        appendBuf(res, buf);
        if(res.length()>0 && res.charAt(res.length()-1)==' ')res.setLength(res.length()-1);
        return res.toString();
    }
    
    private void appendBuf(StringBuilder res, StringBuilder buf){
        int i = buf.length()-1;
        while(i>=0){
            res.append(buf.charAt(i));
            if(i==0)res.append(' ');
            i--;
        }
        buf.setLength(0);
    }
}