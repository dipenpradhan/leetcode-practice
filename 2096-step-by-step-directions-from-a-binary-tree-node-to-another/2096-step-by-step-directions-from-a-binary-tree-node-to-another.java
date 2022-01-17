/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    
    /*
        DFS
        startFound
        destFound
        
        fn int dfs(node, start, dest, up, down, direction
            
            if node null or (startFound and endFound):
                exit 0
            
            if node is start:
                exit -1
                
            if node is dest:
                exit 1
                
            left = dfs(left,...L
            right = dfs(right,...R
            
            if left and right both are not 0:
                exit 2
            
            if left or right is -1:
                append U to up string
                exit -1
            
            if left is 1:
                append L to down string
                exit 1
            
            if right is 1:
                append R to down string
                exit 1
    */
    
    StringBuilder result = new StringBuilder();
    int start, dest;
    int countUp = 0;
    StringBuilder down = new StringBuilder();
    
    public String getDirections(TreeNode root, int startValue, int destValue) {
        
        this.start = startValue;
        this.dest = destValue;
        
        dfs(root, null);
      
        for(int i = 0; i < countUp; i++){
            result.append('U');
        }
        
        result.append(down.reverse().toString());
        
        return result.toString();
    }
    
    private int dfs(TreeNode node, Character direction){
        int code = 0;
        
        if(node == null) return code;
        
        if(node.val == start){
            code = 1;
        }else if(node.val == dest){
            code = 2;
        }
        
        int left = dfs(node.left, 'L');
        
        int right = dfs(node.right, 'R');
        
        boolean lca = code + left + right == 3;
        
        if(left == 1 || right == 1){
            countUp++;
            code = 1;
        }
        
        if(left == 2){
            down.append('L');
            code = 2;
        }else if(right == 2){
            down.append('R');
            code = 2;
        }
        

        return lca?-1:code;
    }
    
}