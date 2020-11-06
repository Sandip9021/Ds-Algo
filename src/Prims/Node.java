package Prims;

public class Node {
   
	private int key;
	private int weight;
	private int fromKey;
	
	public Node(int fromKey,int key,int weight) {
		this.key=key;
		this.weight=weight;
		this.fromKey=fromKey;
	}
	
	public int getKey() {
		return key;
	}

	public void setKey(int key) {
		this.key = key;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	public int getFromKey() {
		return fromKey;
	}

	public void setFromKey(int fromKey) {
		this.fromKey = fromKey;
	}
	
}
