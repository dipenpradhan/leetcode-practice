class Solution {
    public int strStr(String haystack, String needle) {
        
        if(needle.length()==0) return 0;
        else if(needle.length()>haystack.length()) return -1;
        
        char[] hay = haystack.toCharArray();
        char[] need = needle.toCharArray();
        int i = 0;
        while(i < hay.length && hay.length - i +1 > need.length){ // 
            int j = 0;
            
            boolean found = true;
            int update = i;
            while(i+j < hay.length && j < need.length){
                
                if(update == i && hay[i+j] == need[0]) update = i+j;
                
                char h = hay[i+j];
                char n = need[j];
                if(h!=n){
                  found = false;
                  break;
                } 
                j++;
            }
            
            if(j==need.length && found) return i;
            if(update!=i) i = update;
            else i++;
        }
        return -1;
        
    }
}