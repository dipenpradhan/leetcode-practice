class Solution {
    public int titleToNumber(String columnTitle) {
        char[] col = columnTitle.toCharArray();
        int tot = 0;
        int f = 1;
        for(int i = col.length-1; i >= 0; i--){
            char c = col[i];
            tot+= f*((c-'A')+1);
            f*=26;
        }
        
        return tot;
    }
}
// ZY