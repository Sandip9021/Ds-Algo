package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeRightSideView {
	static int maxLevel = -1;

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

	// Solution 1
	 public List<Integer> rightSideViewSol1(TreeNode root) {
         List<Integer> result = new ArrayList<>();
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
				if(i==queueSize-1) {
					result.add(node.val);
				}
				li.add(node.val);
				if (node.left != null) {
					queue.add(node.left);
				}
				if (node.right != null) {
					queue.add(node.right);
				}
			}
		}
		return result;
    }
	 
	 //Solution 2
	 public List<Integer> rightSideViewSol2(TreeNode root) {
         List<Integer> ans = new ArrayList<>();
       if (root == null) return ans;
       
       Queue<TreeNode> queue = new LinkedList<>();
       queue.add(root);
       
       while (!queue.isEmpty()) {
           int size = queue.size();
           ans.add(queue.peek().val);
           
           for (int i = 0; i < size; i++) {
               TreeNode node = queue.poll(); 
               if (node.right != null) queue.add(node.right);
               if (node.left != null) queue.add(node.left);
           }
       }
       
       return ans;
   }

	 // Solution 3
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> ls = new ArrayList<>();
		maxLevel = -1;
		traverse(root, 0, ls);
		return ls;
	}

	public static void traverse(TreeNode root, int level, List<Integer> ls) {
		if (root == null)
			return;
		if (level > maxLevel) {
			ls.add(root.val);
			maxLevel = level;
		}
		traverse(root.right, level + 1, ls);
		traverse(root.left, level + 1, ls);
	}

}
