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
    
    private int count = 0;
    
    public int pathSum(TreeNode root, int targetSum) {
        
        /*
            count = 0
            
            fn pathSum(root, target):
                
                dfs(root, prefixSumCounts<sum, count>, currSum, target
                
            fn dfs(node, prefixSumCounts, currSum, target
            
                if node is null:
                    STOP
                
                currSum += node.val 
                
                if currSum - target is present in prefixSumCounts:
                    count++
                
                increment count of currSum in prefixSumCounts
                
                dfs(left...
                dfs(right...
                
        */
        
        Map<Integer, Integer> prefixSumCounts = new HashMap<Integer, Integer>();
        prefixSumCounts.put(0,1);
        
        backtrack(root, prefixSumCounts, 0, targetSum);
        
        return count;
    }
    
    
    private void backtrack(TreeNode node, Map<Integer, Integer> prefixSumCounts, int currSum, int target){
        
        if(node == null)
            return;
        
        currSum += node.val;
        
        int prefixSum = currSum - target;
        
        if(prefixSumCounts.containsKey(prefixSum)){
            count += prefixSumCounts.get(prefixSum);
        }
        
        if(prefixSumCounts.containsKey(currSum)){
            prefixSumCounts.put(currSum, prefixSumCounts.get(currSum) + 1);
        }else{
            prefixSumCounts.put(currSum, 1);
        }
        
        backtrack(node.left, prefixSumCounts, currSum, target);
        backtrack(node.right, prefixSumCounts, currSum, target);
        
        prefixSumCounts.put(currSum, prefixSumCounts.get(currSum) - 1);
    }
    
}