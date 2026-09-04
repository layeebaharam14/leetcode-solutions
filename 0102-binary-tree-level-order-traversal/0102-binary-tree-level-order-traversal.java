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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList();
	    List<List<Integer>> l = new ArrayList();
	    if(root!=null) {
            q.offer(root);
		   
		    while(!q.isEmpty()) {
                int size=q.size();
                List<Integer> res = new ArrayList();

                for(int i=0;i<size;i++){
                    TreeNode temp = q.poll();
			   
			        if(temp.left!=null)
				        q.offer(temp.left);
			   
			        if(temp.right!=null)
				        q.offer(temp.right);
                    
                    res.add(temp.val);
                }
                l.add(res);
		    }
	    }
	    return l;
    }
}