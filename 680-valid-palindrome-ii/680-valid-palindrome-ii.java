class Solution {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length()-1;
        
        return isValidPalindrome(s, l, r, false);

    }
    
    private boolean isValidPalindrome(String s, int l, int r, boolean del){
        while(l<=r){
            // System.out.println("L "+l+" "+s.charAt(l)+" R "+r+" "+s.charAt(r));
            if(s.charAt(l)==s.charAt(r)){
                l++; r--;
            }else if (!del){
                // System.out.println("Setting del true");
                return isValidPalindrome(s, l, r-1, true) || isValidPalindrome(s, l+1, r, true);
            }else{
                // System.out.println("returning false, del="+del);
                return false;
            }
        }
        return true;
    }
    
}
// "aguokepatgbnvfqmgmlc u puufxoohdfpgjdmysgvhmvffcnqxjjxqncffvmhvgsymdjgpfdhooxfuupuc u lmgmqfvnbgtapekouga"