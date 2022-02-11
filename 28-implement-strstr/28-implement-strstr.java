class Solution {
    public int strStr(String haystack, String needle) {
        
        if(needle.length()==0) return 0;
        else if(needle.length()>haystack.length()) return -1;
        
        int i = 0;
        while(i < haystack.length() && haystack.length() - i +1 > needle.length()){ // 
            int j = 0;
            
            boolean found = true;
            while(i+j < haystack.length() && j < needle.length()){
                char h = haystack.charAt(i+j);
                char n = needle.charAt(j);
                if(h!=n){
                  found = false;
                  break;
                } 
                j++;
            }
            
            if(j==needle.length() && found) return i;
            i++;
        }
        return -1;
        
    }
}