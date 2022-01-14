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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        
        /*
            
            fn pathSum(root, target):
                result = [][]
                currentPath = []
                backtrack(root, result, currentPath, target)
                
            fn backtrack(node, result, currentPath, remaining):
                
                if node is null STOP
                
                add node to currentPath
                
                if remaining is same as node value, and we are at leaf node
                    add currentPath to result
                else
                    // go down left and right child                
                    backtrack(node.left, result, currentPath, remaining - node.val)
                    backtrack(node.right, result, currentPath, remaining - node.val)
                    
                remove node from currentPath
                
        */
        
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> currentPath = new ArrayList<>();
        
        backtrack(root, result, currentPath, targetSum);
        return result;
    }
    
    private void backtrack(TreeNode node, List<List<Integer>> result, List<Integer> currentPath, int remaining){
        if(node == null) return;
        
        currentPath.add(node.val);

        if(node.left == null && node.right == null && remaining == node.val) {
            List<Integer> resultItem = new ArrayList<Integer>();
            resultItem.addAll(currentPath);
            result.add(resultItem); 
        }else{
            backtrack(node.left, result, currentPath, remaining - node.val);
            backtrack(node.right, result, currentPath, remaining - node.val);   
        }
        
        currentPath.remove(currentPath.size()-1);
    }
}