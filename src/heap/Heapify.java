package heap;

public class Heapify {

	public static void main(String[] args) {
		int[] data = { 1, 3, 37, 2, 18, 27, 101, 16, 8 };
		printHeap(data);
		System.out.println('\n' + "___________________________________________");
		heapify(data);
	}

	public static void heapify(int[] data) {
		int end = data.length - 1;
		int startPoint = (end - 1) / 2;

		while (startPoint >= 0) {
			shiftDown(data, startPoint, end);
			startPoint--;
		}
	}

	public static void shiftDown(int[] data, int start, int end) {
		int parent = start;

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
			System.out.println('\n' + "___________________________________________");
			printHeap(data);
		}
		//printHeap(data);
		System.out.println('\n' + "___________________________________________");
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
