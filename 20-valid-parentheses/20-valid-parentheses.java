class Solution {
    
//     Map<Character, Character> map;
//     
//     Solution(){
//         map = new HashMap<Character, Character>();
//         map.put('}','{');
//         map.put(']','[');
//         map.put(')','(');    
//     }
//     public boolean isValid(String s) {

//         Stack<Character> stk = new Stack<Character>();
        
//         for(char c : s.toCharArray()){
            
//             if(!map.containsKey(c)){
//                 stk.push(c);
//             }else if(stk.isEmpty() || stk.peek() != map.get(c)){
//                 return false;
//             }else{
//                 stk.pop();
//             }
            
//         }
        
//         return stk.isEmpty();
        
//     }
    
        public boolean isValid(String s) {
            Stack<Character> stk = new Stack();
            
            for(char c : s.toCharArray()){
                
                if(c == '{' || c == '(' || c == '['){
                    stk.push(c);
                }else{
                    if(stk.isEmpty()) return false;
                    
                    char p = stk.pop();
                    if(c == '}' && p != '{') return false;
                    if(c == ')' && p != '(') return false;
                    if(c == ']' && p != '[') return false;
                }
                
            }
            
            return stk.isEmpty();
            
        }

}