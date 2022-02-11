class Solution {
    public int strStr(String haystack, String needle) {
        
        if(needle.length()==0) return 0;
        else if(needle.length()>haystack.length()) return -1;
        
        int i = 0;
        while(i < haystack.length() && haystack.length() - i +1 > needle.length()){ // 
            int j = 0;
            
            boolean found = true;
            int update = i;
            while(i+j < haystack.length() && j < needle.length()){
                
                if(update == i && haystack.charAt(i+j) == needle.charAt(0)) update = i+j;
                
                char h = haystack.charAt(i+j);
                char n = needle.charAt(j);
                if(h!=n){
                  found = false;
                  break;
                } 
                j++;
            }
            
            if(j==needle.length() && found) return i;
            if(update!=i) i = update;
            else i++;
        }
        return -1;
        
    }
}



//  // i0 h // i1 e //i3 l
//       0123456789