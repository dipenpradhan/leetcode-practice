class Solution {
    public String simplifyPath(String path) {
        Deque<String> q = new ArrayDeque<String>();
        
        StringBuilder p = new StringBuilder();
            
        for(int i = 0; i < path.length(); i ++){
            
            char c = path.charAt(i);
            if(c!='/'){
                p.append(c);
            }
            if((c == '/' || i == path.length()-1) && p.length() > 0){
                
                if(p.toString().equals("..")){
                    if(!q.isEmpty()) q.pollLast();
                }else if(!p.toString().equals(".")){
                    q.offer(p.toString());
                }
                p.setLength(0);
                
            }
            
        }
        StringBuilder res = new StringBuilder();
        res.append("/");
        while(!q.isEmpty()){
            res.append(q.poll());
            res.append("/");
        }
        if(res.length() > 1){
            res.setLength(res.length()-1);
        }
        return res.toString();
    }
}