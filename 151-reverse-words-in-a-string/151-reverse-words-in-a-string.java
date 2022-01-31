class Solution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        StringBuilder buf = new StringBuilder();
        
        for(int i = s.length()-1; i>=0; i--){ // scan from right
            char c = s.charAt(i);
            if(c!=' ') buf.append(c);
            else appendBuf(res, buf);
        }
        appendBuf(res, buf);
        return res.toString();
    }
    
    private void appendBuf(StringBuilder res, StringBuilder buf){
        int i = buf.length()-1;
        if(i>=0 && res.length()>0) res.append(' ');
        while(i>=0){
            res.append(buf.charAt(i));
            i--;
        }
        buf.setLength(0);
    }
}