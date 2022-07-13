class Solution {
  public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
		if (root == null) {
			return result;
		}
		LinkedList<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int queueSize=queue.size();
			List<Integer> li = new ArrayList<>();
			for(int i=0;i<queueSize;i++) {
				TreeNode node = queue.poll();
				li.add(node.val);
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
			result.add(li);
		}
		return result;
    }
}
