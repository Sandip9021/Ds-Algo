package heap;

public class InsertIntoMaxHeap {
	
	public static void main(String[] args) {
		int[] data = { 101,18,37,16,3,27,1,2,8};
		printHeap(data);
		int k=41;
		System.out.println("\n"+"----------------After inserting "+k+" --------------------");
		insertIntoHeap(data,k);
	}
	
	public static void insertIntoHeap(int[] data,int n) {
		int[] heap=resizeHeap(data);
		heap[heap.length-1]=n;
		int[] newHeap=percolateUp(heap);
		printHeap(newHeap);
	}
	
	public static int[] resizeHeap(int[] data) {
		int[] copy = new int[data.length + 1];
		//System.arraycopy(data, 0, copy, 0, data.length+1);
		for(int i=0;i<data.length;i++) {
			copy[i]=data[i];
		}
		return copy;
	}
	
	public static int[] percolateUp(int[] data) {
		int insertedPos=data.length-1;
		int parent= (insertedPos-1)/2;
		while (data[parent] < data[insertedPos]) {
				int temp = data[insertedPos];
				data[insertedPos] = data[parent];
				data[parent] = temp;
				
		        insertedPos=parent;
		        parent= (insertedPos-1)/2;
		}
		return data;
	}
	
	public static void printHeap(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "  ");
			if (i == 0 || i == 2 || i == 6 || i == 14) {
				System.out.println();
			}
		}
	}
}
