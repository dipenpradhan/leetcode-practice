class Solution {
    public int strStr(String haystack, String needle) {
        // edge cases:
        // needle blank, haystack blank
        // hello, ll
        
        
           
        if(needle.length() == 0){
            return 0;
        }else if(haystack.length() == 0){
            return -1;
        }
        
        char[] charHay = haystack.toCharArray();
        char[] charNdl = needle.toCharArray();
        
        for (int i = 0; i < charHay.length; i++){
            char h = charHay[i];
            // System.out.println("charHay["+i+"]="+charHay[i]);
            if(i > charHay.length - charNdl.length){
                return -1;
            }
            if(h == charNdl[0]){
                boolean found = true;
                for(int j = 0; j < charNdl.length; j++){
                    // System.out.println("found i="+i+" j= "+j+" char[i+j]="+charHay[i+j]+" charNdl[j]="+charNdl[j]);
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