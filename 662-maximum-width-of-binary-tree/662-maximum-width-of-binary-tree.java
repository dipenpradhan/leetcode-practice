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
    public int widthOfBinaryTree(TreeNode root) {
        
        // We start exploring from root 
        // Using BFS + level order traversal assign numbers in sequence to each child
        
        // Create a hashmap to store element number
        // Create empty queue
        // add root to queue
        // set root width to 1 and elNum to 0 in hashmap
        // while queue is not empty:
        //      record N = size of queue (number of nodes at the level)
        //      poll N nodes from queue
        //          record first node number
        //          record last node number
        //          width = (difference between last and first) + 1
        //          add children of each polled node to queue
        //          add node number for each child of each polled node to hashmap
        //              start from 0
        //              first child found should have number 0
        //              increment count by 2 for each child after first child is found
        //              assign currNodeNum and currNodeNum+1 to left and right child (if exists)
        
        
        
        Map<TreeNode, Integer> nodeNums = new HashMap<TreeNode, Integer>();
        Queue<TreeNode> nodeQ = new LinkedList<TreeNode>();
        
        nodeNums.put(root, 0);
        nodeQ.offer(root);
        
        int width = 1;
        int maxWidth = 1;
        while(!nodeQ.isEmpty()){
            
            
            int N = nodeQ.size();
            TreeNode firstNode = nodeQ.peek();
            TreeNode node = null;
            int i = 0;
            
            while(i < N){
                
                node = nodeQ.poll();
                if(node.left != null) {
                    nodeQ.offer(node.left);
                    nodeNums.put(node.left, 2*nodeNums.get(node));
                }
                if(node.right != null){
                    nodeQ.offer(node.right);
                    nodeNums.put(node.right, 2*nodeNums.get(node)+1);
                } 
                // System.out.print ("node="+node.val+" num="+nodeNums.get(node)+" | ");
                
                i++;
            }
            width = nodeNums.get(node) - nodeNums.get(firstNode) + 1;
                    // System.out.println("");
            maxWidth = Math.max(maxWidth, width);
        }
        
        // for(TreeNode n : nodeNums.keySet()){
        //     System.out.print("node="+n.val+" num="+nodeNums.get(n)+" | ");
        // }
        return maxWidth;
        
    }
}
//[1,3,2,5,3,null,9]
//[1,3,null,5,3]
//[1,3,2,5]
