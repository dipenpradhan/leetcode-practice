class Solution {
    public int characterReplacement(String s, int k) {
        
        /*
            fn characterReplacement(string, k):
                // Create a sliding window with 2 pointers
                left = 0
                right = 0
                maxLen = 0
                maxCharCount = 0
                
                seenCount<char, count> = []
                
                loop through start to end of array:
                    if count of char added from right side of window becomes greatest:
                        update maxCount to this value
                    
                    if window length > max:
                        update max
                    
                    if window length - maxCharCount > k
                        max valid window exceeded
                        attempt to find new window which will increase maxCharCount and give new valid window of longer length
                        keep window length same (maxLen+1) until this is found
                    
                    stop at end of array: last window length checked = (maxLen+1)
                        
        */
        
        
        int left = 0, right = 0, maxLen = 0, maxCharCount = 0;
        
        Map<Character, Integer> seenCount = new HashMap<Character, Integer>();
        
        
        while(left <= right && right < s.length()){
            
            char c = s.charAt(right);
            
            if(seenCount.containsKey(c)){
                seenCount.put(c, seenCount.get(c) + 1);
            }else{
                seenCount.put(c, 1);
            }
            
            maxCharCount = Math.max(maxCharCount, seenCount.get(c));
            
            int windowLen = right - left + 1;
            
            if(windowLen - maxCharCount > k){
                seenCount.put(s.charAt(left), seenCount.get(s.charAt(left))-1);
                left++;
            }else{
                maxLen = Math.max(maxLen, windowLen);
            }
            // System.out.println("left="+left+" right="+right+" maxCharCount="+maxCharCount+" maxLen="+maxLen+" windowLen="+windowLen);
            right++;
        }
        return maxLen;
    }
}