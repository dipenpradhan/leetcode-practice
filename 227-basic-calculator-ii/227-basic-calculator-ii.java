class Solution {
    public int calculate(String s) {
        
        if(s == null || s.length() == 0) return 0;
        
        Stack<Integer> resultStack = new Stack<Integer>();
        int currNum = 0;
        char currOp = '+';
        
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == ' ' && i != s.length()-1){
                continue;
            }
            
            if(c >= '0' && c <= '9'){
                currNum = currNum*10 + Character.getNumericValue(c);
            }
            
            if(c < '0' || c > '9' || i == s.length()-1){
                 switch(currOp){
                    case '+': resultStack.push(currNum); break;
                    case '-': resultStack.push(-currNum); break;
                    case '/': resultStack.push(resultStack.pop() / currNum); break;
                    case '*': resultStack.push(resultStack.pop() * currNum); break;
                }
                currOp = c;
                currNum = 0;
            }
        }
        int result = 0;
        while(!resultStack.isEmpty()){
            result += resultStack.pop();
        }
        return result;
    }
    
    
}