class Solution {
    public String removeDuplicates(String s) {
        
        Deque<Character> dq = new ArrayDeque<Character>();
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            
            if(dq.size() > 0 && dq.peekLast() == c){
                dq.removeLast();
            }else{
                dq.addLast(c);    
            }
            
        }
        
        StringBuilder res = new StringBuilder();
        while(dq.size()>0){
            res.append(dq.pollFirst());
        }
        return res.toString();
    }
}