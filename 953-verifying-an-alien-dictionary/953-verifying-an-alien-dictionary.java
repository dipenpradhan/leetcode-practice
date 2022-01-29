class Solution {
    
    public boolean isAlienSorted(String[] words, String order) {
        
        int[] alpha = new int[26];
        
        for(int i = 0; i < order.length(); i++){
            char c = order.charAt(i);
            alpha[c-'a'] = i;
        }
        
        
        for(int i = 0; i < words.length - 1; i++){
            String first = words[i];
            String second = words[i+1];
            
            int j = 0;
            while(j < first.length() && j < second.length() && first.charAt(j) == second.charAt(j) ){
                
                j++;
            }
            
            if(first.length() > second.length() && j >= second.length()){
                return false;
            }else if(j < first.length() && j < second.length() && alpha[first.charAt(j)-'a'] > alpha[second.charAt(j)-'a']){
                return false;
            }
        }
        
        return true;
        
    }
    
}