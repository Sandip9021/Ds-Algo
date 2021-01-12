package Tree;

import java.util.Stack;

public class InOrderTraversal {
	
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
		root.right.left=new TreeNode(6);
		root.right.right=new TreeNode(7);
		
		InOrderTraversal pot=new InOrderTraversal();
		 pot.inOrderTraversalRecursion(root);
		 System.out.println("\n-------------------------------------");
		 pot.inOrderTraversalIterative(root);
		
	}
	
	public void inOrderTraversalRecursion(TreeNode root) {
		 if(root!=null) {
			 inOrderTraversalRecursion(root.left);
			 System.out.print(root.data+"  ");
			 inOrderTraversalRecursion(root.right);
		 }
	}
	
	public void inOrderTraversalIterative(TreeNode root) {
		 if(root==null) {
			 System.out.println("Root is null");
			 return;
		 }
		 
		 Stack<TreeNode> stack=new Stack<>();
		 TreeNode current=root;
		 
		 while(true) {
			 if(current!=null) {
				 stack.push(current);
				 current=current.left;
			 }else {
				 if(stack.isEmpty()) {
					 break;
				 }else {
					 current=stack.pop();
					 System.out.print(current.data+"   ");
					 current=current.right;
				 }
			 }
		 }
		
	}
	
	
	
	
}
