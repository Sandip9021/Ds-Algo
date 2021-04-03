package Tree;

public class SumRootToLeafNumbers {
	int totalSum = 0;

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

	public int sumNumbers(TreeNode root) {
		preOrder(root, 0);
		return totalSum;
	}

	private void preOrder(TreeNode root, int num) {
		if (root == null) {
			return;
		}
		
		if (root.left == null && root.right == null) {
			num = num * 10 + root.val;
			totalSum = totalSum + num;
		}

		preOrder(root.left, num * 10 + root.val);
		preOrder(root.right, num * 10 + root.val);
	}
}
