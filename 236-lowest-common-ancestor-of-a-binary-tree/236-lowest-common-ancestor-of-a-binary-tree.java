/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {

    /*
                3
            5        1
          6   2     0  8
             7 4  
    
    
        count = 0
        
        fn lca(root, p, q):
            
            dfs(root, p, q)
        
        fn dfs(node, p, q):
            record prevCount 
            if node is p or q:
                count++
            
            dfs(left
            dfs(right
            
            if count reaches 2 and prevCount was 0
                return node
            
    */
    
    private int count = 0;
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        return dfs(root, p, q);
        
    }
    
    private TreeNode dfs(TreeNode node, TreeNode p, TreeNode q){
        
        if(node == null) return null;
        int prevCount = count;
        
        boolean currIsResult = false;
        if(node.val == p.val || node.val == q.val){
            count++;
            currIsResult = true;
        }
        
        TreeNode left = dfs(node.left, p, q);
        TreeNode right = dfs(node.right, p, q);
        
        if(currIsResult && (left != null || right!=null))
            return node;
        if(left!=null && right!=null)
            return node;
        
        if(currIsResult) return node;
        
        return left!=null?left:right!=null?right:null;
    }
}