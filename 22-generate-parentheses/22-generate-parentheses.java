class Solution {
    
    
    int n;
    public List<String> generateParenthesis(int n) {
        this.n = n;
        
        List<String> res = new ArrayList<String>();
        StringBuilder curr = new StringBuilder();
        
        genPar(curr, res, 0, 0);
      
        return res;
    }
    
    
    private void genPar(StringBuilder curr, List<String> res, int start, int end){
        if(curr.length() == n *2){
            if(start == n && end == n){
                res.add(curr.toString());    
            }
            
            return;
        }
        
        for(int i = start; i <= n; i++){
            curr.append("(");
            genPar(curr, res, i+1, end);
            curr.setLength(curr.length()-1);
        }
        
        if(end<start){
            curr.append(")");
            genPar(curr, res, start, end+1);
            curr.setLength(curr.length()-1);
        }
        
    }
}