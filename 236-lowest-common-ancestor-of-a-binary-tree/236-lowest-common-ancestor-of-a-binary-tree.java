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
    
        
        fn lca(root, p, q):
            
            dfs(root, p, q)
        
        fn dfs(node, p, q):
        
            if node is p or q:
                node can be result
            
            dfs(left
            dfs(right
            
            if node matches p or q and left or right return other result then node is LCA
            if node does not match p or q but left and right both return a result then node is LCA
            
            else return whichever is not null between left and right
    */
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        
        return dfs(root, p, q);
        
    }
    
    private TreeNode dfs(TreeNode node, TreeNode p, TreeNode q){
        
        if(node == null) return null;
        
        boolean currIsResult = false;
        if(node.val == p.val || node.val == q.val){
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