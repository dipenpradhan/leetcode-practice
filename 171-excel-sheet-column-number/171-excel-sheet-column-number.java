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

// 76504
// 4*1
// 0*10 + 4 = 4
// 5*100 + 4 = 504
// 6*1000 + 504 = 6504
// 7*10000 + 6504 = 76504


// val(X)=> X-A+1 (A=1, X=25)
// f*tot+val(X)  f = 1
