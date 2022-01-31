class Solution {
    public int maximumWealth(int[][] accounts) {
        
        int max = 0;
        for(int[] wealth : accounts){
            int sum = 0;
            for(int w : wealth){
                sum += w;
            }
            max = Math.max(max, sum);
            
        }
        return max;
    }
}