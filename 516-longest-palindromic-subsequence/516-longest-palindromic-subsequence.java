class Solution {
    public int longestPalindromeSubseq(String s) {
        int[][] memo = new int[s.length()+1][s.length()+1];
        //    _  b  b  a  b
        // _  0  0. 0. 0. 0 
        // b  0  1. 2  2. 2
        // a  0  1  2
        // b  0
        // b  0
        
        
        // set up base case
//         for(int i = 1; i < memo.length; i++){
//             memo[i][0] = 1;
//             memo[0][i] = 1;
//         }
        
        for(int i = 1; i < memo.length; i++){
            for(int j = 1; j < memo.length; j++){
                char a = s.charAt(i-1);
                char b = s.charAt(s.length()-j);
                
                if(a==b){
                    memo[i][j] = memo[i-1][j-1]+1;//Math.max(memo[i-1][j], memo[i][j-1]) + 1;
                }else{
                    memo[i][j] = Math.max(memo[i-1][j], memo[i][j-1]);
                }
            }
        }
        return memo[s.length()][s.length()];
    }
}