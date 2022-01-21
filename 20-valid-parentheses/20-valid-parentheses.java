class Solution {
    
    Map<Character, Character> map;
    
    Solution(){
        map = new HashMap<Character, Character>();
        map.put('}','{');
        map.put(']','[');
        map.put(')','(');    
    }
    public boolean isValid(String s) {

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