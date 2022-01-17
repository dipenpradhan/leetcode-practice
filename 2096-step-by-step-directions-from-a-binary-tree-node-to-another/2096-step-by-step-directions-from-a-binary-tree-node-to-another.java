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
        
        result
        answerFound
        countUp
        constants FOUND_START, FOUND_DEST, NONE
        fn int dfs(node, start, dest, down):
            
            
    */
    
    private StringBuilder result = new StringBuilder();
    private boolean answerFound = false;
    private int countUp = 0;
    private static final int FOUND_NONE = 0, FOUND_START = 1, FOUND_DEST = 2, FOUND_BOTH = 3;
    
    public String getDirections(TreeNode root, int startValue, int destValue) {
        
       StringBuilder down = new StringBuilder();
       
        dfs(root, startValue, destValue, down);
      
        for(int i = 0; i < countUp; i++){
            result.append('U');
        }
        
        result.append(down.reverse().toString());
        
        return result.toString();
    }
    
    private int dfs(TreeNode node, int start, int dest, StringBuilder down){
        
        int code = FOUND_NONE;
        
        if(answerFound || node == null) return code;
        
        if(node.val == start){
            code = FOUND_START;
        }else if(node.val == dest){
            code = FOUND_DEST;
        }
        
        int left = dfs(node.left, start, dest, down);
        
        int right = dfs(node.right, start, dest, down);
        
        answerFound = code + left + right == FOUND_BOTH;
        
        if(left == FOUND_START || right == FOUND_START){
            countUp++;
            code = FOUND_START;
        }
        
        if(left == FOUND_DEST){
            down.append('L');
            code = FOUND_DEST;
        }else if(right == FOUND_DEST){
            down.append('R');
            code = FOUND_DEST;
        }
        
        
        return answerFound ? -1 : code;
    }
    
}