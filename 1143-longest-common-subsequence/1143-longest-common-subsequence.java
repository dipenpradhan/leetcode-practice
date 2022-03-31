class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        // abcde
        // a - ab ac ad ae - abc abd abe - acd ace - 
        // b
        // c
        // d
        // e
        
        //     "" a  b  c  d  e
        // ""  0  0. 0. 0. 0. 0
        //  a  0. 1  1  1. 1  1
        //  c  0. 1  1  2  2  2
        //  e  0. 1  1  2  2  3
        //
        
        int[][] memo = new int[text1.length()+1][text2.length()+1];
        
        for(int i = 1; i < memo.length; i++){
            for(int j = 1; j < memo[i].length; j++){
                char a = text1.charAt(i-1);
                char b = text2.charAt(j-1);
                
                if(a==b){
                    memo[i][j] = memo[i-1][j-1] + 1;
                }else{
                    memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);
                }
                
            }
        }
        return memo[text1.length()][text2.length()];
    }
}