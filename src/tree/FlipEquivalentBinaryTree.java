package Tree;

public class FlipEquivalentBinaryTree {
	
	static class TreeNode {	
		public int val;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int val) {
			this.val = val;
			this.left = null;
			this.right = null;
		}

		@Override
		public String toString() {
			return "TreeNode [val=" + val + ", left=" + left + ", right=" + right + "]";
		}
	}
	
	public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        if (root1 == root2)
	            return true;
	        if (root1 == null || root2 == null || root1.val != root2.val)
	            return false;

	        return (flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) ||
	                flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left));
   }

}
