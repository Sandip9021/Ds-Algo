package Tree;

public class NodeBinaryTree {	
	private int data;
	private NodeBinaryTree left;
	private NodeBinaryTree right;
	
	public NodeBinaryTree(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}
	
	public int getData() {
		return data;
	}
	public void setData(int data) {
		this.data = data;
	}
	public NodeBinaryTree getLeft() {
		return left;
	}
	public void setLeft(NodeBinaryTree left) {
		this.left = left;
	}
	public NodeBinaryTree getRight() {
		return right;
	}
	public void setRight(NodeBinaryTree right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "NodeBinaryTree [data=" + data + ", left=" + left + ", right=" + right + "]";
	}
}
