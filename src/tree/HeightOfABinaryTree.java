package Tree;


public class HeightOfABinaryTree {
	static class TreeNode {	
		public int data;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}

		@Override
		public String toString() {
			return "TreeNode [data=" + data + ", left=" + left + ", right=" + right + "]";
		}
	}
	
	public static void main(String[] args) {
		TreeNode root =new TreeNode(1);
		TreeNode left =new TreeNode(2);
		TreeNode right =new TreeNode(3);
		root.left=left;
		root.right=right;
		root.left.left=new TreeNode(4);
		root.left.right=new TreeNode(5);
		root.left.right.left=new TreeNode(8);
		root.left.right.left.left=new TreeNode(9);
		root.left.right.left.left.left=new TreeNode(10);
		root.right.left=new TreeNode(6);
		root.right.right=new TreeNode(7);
		
		HeightOfABinaryTree pot=new HeightOfABinaryTree();
		int height=pot.findHeightOfTree(root);
		System.out.println("Heighest height : "+height);
	}
	
	public int findHeightOfTree(TreeNode root) {
		 if(root!=null) {
			 int leftHeight=findHeightOfTree(root.left);
			 int rightHeight=findHeightOfTree(root.right);
			 return Math.max(leftHeight, rightHeight)+1;
		 }else {
			 return 0;
		 }
	}

}
