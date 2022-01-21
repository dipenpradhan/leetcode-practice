class Solution {
    private static final int BR = 0, RD = 1, SQ = 2;
    
    public boolean isValid(String s) {
        
        int[] op = new int[3];
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');
        
        Stack<Character> stk = new Stack<Character>();
        
        for(char c : s.toCharArray()){
            
            if(!map.containsKey(c)){
                stk.push(c);
            }else if(stk.isEmpty() || stk.peek() != map.get(c)){
                return false;
            }else{
                stk.pop();
            }
            
        }
        
        return stk.isEmpty();
        
    }
}