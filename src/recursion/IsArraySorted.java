package recursion;

public class IsArraySorted {
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		//int[] arr = {1,2,4,3,5};
		int[] arr2 = {56,32,30,12};
		isArraySortedAscOrder(arr,0);
		isArraySortedDescOrder(arr2,0);
	}
	
	public static void isArraySortedAscOrder(int[] arr,int index) {
		if(arr.length<=1 || index==arr.length-2) {
			System.out.println("Array is sorted");
			return;
		}else {
			if(arr[index]<arr[index+1]) {
				isArraySortedAscOrder(arr,++index);
			}else {
				System.out.println("Array is Not sorted");
				return;
			}		
		}
	}
	
	public static void isArraySortedDescOrder(int[] arr,int index) {
		if(arr.length<=1 || index==arr.length-2) {
			System.out.println("Array is sorted");
			return;
		}else {
			if(arr[index]>arr[index+1]) {
				isArraySortedDescOrder(arr,++index);
			}else {
				System.out.println("Array is Not sorted");
				return;
			}		
		}
	}

}
