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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        
        List<TreeNode> result = new ArrayList<TreeNode>();
        Set<Integer> deleteSet = new HashSet<Integer>();
        
        for(int d: to_delete){
            deleteSet.add(d);
        }
        dfs(root, deleteSet, result, true);
        
        return result;
    }
    
    private boolean dfs(TreeNode node, Set<Integer> deleteSet, List<TreeNode> result, boolean addToResult){
        
        if(node == null) return false;
        
        
        if(deleteSet.contains(node.val)){
            addToResult = true;
        }else if (addToResult){
            result.add(node);
            addToResult = false;
        }
        
        
        if(dfs(node.left, deleteSet, result, addToResult)){
            node.left = null;
            
        }
        
        if(dfs(node.right, deleteSet, result, addToResult)){
            node.right = null;
        }
        
        return deleteSet.contains(node.val);
        
    }
    
}