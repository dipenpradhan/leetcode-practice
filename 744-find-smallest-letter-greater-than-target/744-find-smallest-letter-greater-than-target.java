class Solution {
    public char nextGreatestLetter(char[] letters, char target) {
        int N = letters.length;
        int l = 0, r = N - 1;
        char res = '-';
        
        while(l <= r){
            int m = l + (r-l)/2;
            
            if(letters[m] <= target){
                l = m +1;
            }else{
                r = m - 1;
            }
        }
        return l < 0 || l >= N ? letters[0]:letters[l];
        
    }
}