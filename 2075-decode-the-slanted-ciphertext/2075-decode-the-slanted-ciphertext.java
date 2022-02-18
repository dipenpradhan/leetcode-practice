class Solution {
    private static int ROWS, COLS;
    public String decodeCiphertext(String encodedText, int rows) {
        ROWS = rows;
        COLS = (encodedText.length()/rows);
        
        StringBuilder res = new StringBuilder();
        
        for(int c = 0; c < COLS; c++){
            diag(encodedText, 0, c, res);
        }
        int l = res.length()-1;
        while(l>=0){
            if(res.charAt(l)!=' ') break;
            l--;
        }
        res.setLength(l+1);
        return res.toString();
    }
    
    private void diag(String enc, int r, int c, StringBuilder res){
        
        if(r>=ROWS || c>=COLS) return;
        
        int pos = r*COLS + c;
        
        res.append(enc.charAt(pos));
        diag(enc, ++r, ++c, res);
    }
}