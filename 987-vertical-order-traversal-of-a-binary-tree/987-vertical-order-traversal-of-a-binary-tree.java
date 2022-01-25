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
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        Map<Integer, List<Pair<Integer,Integer>>> map = new HashMap<Integer, List<Pair<Integer,Integer>>>();
        
        dfs(root, map, 0, 0);
        
        List<Integer> cl = new ArrayList<Integer>(map.keySet());
        Collections.sort(cl);
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        for(int c: cl){
            Collections.sort(map.get(c), (a,b)->a.getKey() == b.getKey()?a.getValue()-b.getValue():a.getKey()-b.getKey());
            List<Integer> l = new ArrayList();
            for(Pair<Integer,Integer> p: map.get(c)){
                l.add(p.getValue());
            }
            res.add(l);
        }
        return res;
    }
    
    void dfs(TreeNode n, Map<Integer, List<Pair<Integer,Integer>>> map, int r, int c){
        if(n == null) return;
        
        if(!map.containsKey(c)) map.put(c, new ArrayList<Pair<Integer,Integer>>());
        
        map.get(c).add(new Pair<Integer,Integer>(r, n.val));
        dfs(n.left, map, r+1, c-1);
        dfs(n.right, map, r+1, c+1);
        
    }
    
}