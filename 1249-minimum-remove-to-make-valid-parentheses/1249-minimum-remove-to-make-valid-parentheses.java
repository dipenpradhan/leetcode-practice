class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stk = new Stack<Integer>();
        Set<Integer> rem = new HashSet<Integer>();
        for(int i = 0;  i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '('){
                stk.push(i);    
            }else if(c == ')'){
                if(stk.isEmpty()){
                    rem.add(i);
                }else{
                    stk.pop();
                }
            }
            
        }
        
        while(!stk.isEmpty()){
            rem.add(stk.pop());
        }
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < s.length(); i++){
            if(!rem.contains(i)){
                res.append(s.charAt(i));
            }
        }
        
        return res.toString();
    }
}