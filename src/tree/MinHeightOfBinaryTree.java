package Tree;

import java.util.LinkedList;

public class MinHeightOfBinaryTree {
	
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
	
	// Approach 1
	public int minDepth(TreeNode root) {
		if (root != null) {
			int leftHeight = minDepth(root.left);
			int rightHeight = minDepth(root.right);
			if (leftHeight == 0 || rightHeight == 0) {
				return Math.max(leftHeight, rightHeight) + 1;
			}
			return Math.min(leftHeight, rightHeight) + 1;

		} else {
			return 0;
		}
	}
	
	// Approach 2
	public int minDepth2(TreeNode root) {
		if (root == null) {
			return 0;
		}
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);
		int count = 0;
		while (!queue.isEmpty()) {
			count++;
			int queueSize = queue.size();
			for (int i = 0; i < queueSize; i++) {
				TreeNode node = queue.poll();
				if(node.left==null && node.right==null) {
					 return count;
				}
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
						
		}
		return count;
	}

}
