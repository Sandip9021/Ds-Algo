package Tree;

import java.util.Stack;

public class PreOrderTraversal {
	
	static class TreeNode {	
		public int data;
		public TreeNode left;
		public TreeNode right;
		
		public TreeNode(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
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
		
		PreOrderTraversal pot=new PreOrderTraversal();
		pot.preOrderTraversalIterative(root);
	}
	
	public void preOrderTraversalRecursion(TreeNode root) {
		 if(root!=null) {
			 System.out.print(root.data+"  ");
			 preOrderTraversalRecursion(root.left);
			 preOrderTraversalRecursion(root.right);
		 }
	}
	
	public void preOrderTraversalIterative(TreeNode root) {
	      if(root==null) {
	    	  System.out.println("Root is null");
	    	  return;
	      }
	      
	      Stack<TreeNode> stack=new Stack<>();
	      stack.push(root);
	      
	      while(!stack.isEmpty()) {
	    	    TreeNode node=stack.pop();
	    	    System.out.print(node.data+"  ");
	    	    
	    	    if(node.right!=null) {
	    	    	stack.push(node.right);
	    	    }
	    	    if(node.left!=null) {
	    	    	stack.push(node.left);
	    	    }
	      }
	}
	
	

}
