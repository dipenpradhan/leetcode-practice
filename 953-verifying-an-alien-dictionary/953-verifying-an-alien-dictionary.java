class Solution {
    
    public boolean isAlienSorted(String[] words, String order) {
        
        int[] alpha = new int[26];
        
        for(int i = 0; i < order.length(); i++){
            char c = order.charAt(i);
            alpha[c-'a'] = i;
        }
        
        
        for(int i = 0; i < words.length - 1; i++){
            String w1 = words[i];
            String w2 = words[i+1];
            
            int j = 0;
            while(j < w1.length() && j < w2.length() && w1.charAt(j) == w2.charAt(j) ){
                
                j++;
            }
            
            if(w1.length() > w2.length() && j >= w2.length()){
                return false;
            }else if(j < w1.length() && j < w2.length() && alpha[w1.charAt(j)-'a'] > alpha[w2.charAt(j)-'a']){
                return false;
            }
        }
        
        return true;
        
    }
    
}