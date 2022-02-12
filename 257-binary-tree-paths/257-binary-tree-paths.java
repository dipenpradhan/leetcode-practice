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
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<String>();
        List<Integer> p = new ArrayList<Integer>();
        dfs(root, p, res);
        return res;
    }
    
    private void dfs(TreeNode n, List<Integer> p, List<String> res){
        
        if(n == null) return;
        p.add(n.val);
        if(n.left == null && n.right == null){
          buildResult(p, res);
        } 
        
        dfs(n.left, p, res);
        dfs(n.right, p, res);
        p.remove(p.size()-1);
    }
    
    private void buildResult(List<Integer> p, List<String> res){
        StringBuilder buf = new StringBuilder();
        for(int i = 0; i < p.size(); i++){
            if(i!=0) buf.append("->");
            buf.append(p.get(i));
        }
        res.add(buf.toString());
    }
}