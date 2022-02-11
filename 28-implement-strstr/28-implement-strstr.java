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


/*
class Solution {
    public int strStr(String haystack, String needle) {
        if(needle.length() == 0){
            return 0;
        }else if(haystack.length() == 0){
            return -1;
        }
        
        char[] charHay = haystack.toCharArray();
        char[] charNdl = needle.toCharArray();
        
        for (int i = 0; i < charHay.length; i++){
            char h = charHay[i];
            System.out.println("charHay["+i+"]="+charHay[i]);
            if(i > charHay.length - charNdl.length){
                return -1;
            }
            if(h == charNdl[0]){
                boolean found = true;
                for(int j = 0; j < charNdl.length; j++){
                    System.out.println("found i="+i+" j= "+j+" char[i+j]="+charHay[i+j]+" charNdl[j]="+charNdl[j]);
                    if(charHay[i+j] != charNdl[j]){
                        found = false;
                        break;
                    }
                }
                if(found){
                    return i;
                }
            }
            
        }
        return -1;
        
    }
}
*/