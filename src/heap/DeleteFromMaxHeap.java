package heap;

public class DeleteFromMaxHeap {
	private static int heapSize;
	private static int heapCapacity;
	
	public static void main(String[] args) {
		int[] data = {101,18,37,16,3,27,1,2,8};  //maxHeap
		heapCapacity=data.length;
		heapSize=data.length;
		printHeap(data);
		//while(heapSize>0) {
		int deletedNode=deleteFromHeap(data);
		System.out.println("\n"+"----------------After Deleteing the root node "+deletedNode+" --------------------");
		//printHeap(data);
		//}
		//printHeapArray(data);
	}
	
	public static int deleteFromHeap(int[] data) {
		int deletedNode = data[0];
		int lastNode = data[heapSize-1];
		data[0]=lastNode;
		data[heapSize-1]=deletedNode;
		heapSize--;
		percolateDown(data);
		return deletedNode;
	}
	
	public static void percolateDown(int[] data) {
		int parent=0;
		int end=heapSize-1;
		while (2 * parent + 1 <= end) {
			int leftChild = 2 * parent + 1;
			int rightChild = 2 * parent + 2;
			int child = 0;
			if (rightChild > end) {
				child = leftChild;
			} else {
				if (data[leftChild] >= data[rightChild]) {
					child = leftChild;
				} else {
					child = rightChild;
				}
			}
			if (data[child] > data[parent]) {
				int temp = data[child];
				data[child] = data[parent];
				data[parent] = temp;
			}
			parent = child;
		}
	}
	
	public static void printHeap(int[] arr) {
		for (int i = 0; i < heapSize ; i++) {
			System.out.print(arr[i] + "  ");
			if (i == 0 || i == 2 || i == 6 || i == 14) {
				System.out.println();
			}
		}
	}  
	
	public static void printHeapArray(int[] arr) {
		System.out.println("********************************************");
		for (int i = 0; i < heapCapacity ; i++) {
			System.out.print(arr[i] + "  ");
			
		}
	}  
}
